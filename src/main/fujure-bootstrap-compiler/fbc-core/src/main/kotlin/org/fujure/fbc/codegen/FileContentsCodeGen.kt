package org.fujure.fbc.codegen

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.CodeBlock
import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.TypeSpec
import org.fujure.fbc.aast.ADef
import org.fujure.fbc.aast.AExpr
import org.fujure.fbc.aast.AFileContents
import org.fujure.fbc.analyze.BuiltInTypes
import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.ast.Module
import java.lang.reflect.Type
import javax.lang.model.element.Modifier

class FileContentsCodeGen {
    private var staticInitializer: CodeBlock.Builder? = null

    fun generate(annotatedAst: AFileContents): JavaFile {
        val typeSpecBuilder = TypeSpec.classBuilder(annotatedAst.module.moduleName)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)

        for (def in annotatedAst.defs) {
            when (def) {
                is ADef.AValueDef.ASimpleValueDef ->
                    typeSpecBuilder.addField(generateField(def, annotatedAst.module))
            }
        }

        val staticInitializer = staticInitializer
        if (staticInitializer != null) {
            typeSpecBuilder.addStaticBlock(staticInitializer.build())
        }

        return JavaFile
                .builder(annotatedAst.module.packageName, typeSpecBuilder.build())
                .skipJavaLangImports(true)
                .build()
    }

    private fun generateField(simpleValueDef: ADef.AValueDef.ASimpleValueDef, module: Module): FieldSpec {
        val fieldType = toJavaType(simpleValueDef.type)!!
        val builder = FieldSpec.builder(fieldType, simpleValueDef.id,
                Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)

        val initializerCodeBlock = aExpr2CodeBlock(simpleValueDef.initializer, module, simpleValueDef.type)
        return when (initializerCodeBlock) {
            is InitializerCode.InlineCode -> {
                builder
                        .initializer(initializerCodeBlock.code)
                        .build()
            }
            is InitializerCode.BlockCode -> {
                addToStaticInitializer(CodeBlock.of("// initialization code for field \$L\n", simpleValueDef.id))
                addToStaticInitializer(initializerCodeBlock.code)
                addToStaticInitializer(CodeBlock.of("\$L = \$L;\n", simpleValueDef.id, initializerCodeBlock.variable))
                builder.build()
            }
        }
    }

    private fun addToStaticInitializer(code: CodeBlock) {
        if (staticInitializer == null)
            staticInitializer = CodeBlock.builder()

        staticInitializer!!.add(code)
    }

    private fun toJavaType(qualifiedType: QualifiedType?): Type? {
        return when (qualifiedType) {
            BuiltInTypes.Int -> Integer.TYPE
            BuiltInTypes.Unit -> Void::class.java
            BuiltInTypes.Bool -> java.lang.Boolean.TYPE
            BuiltInTypes.Char -> Character.TYPE
            BuiltInTypes.String -> java.lang.String::class.java
            else -> null
        }
    }

    private sealed class InitializerCode() {
        val isCodeABlock = this is InitializerCode.BlockCode

        class InlineCode(val code: CodeBlock) : InitializerCode()
        class BlockCode(val code: CodeBlock, val variable: String) : InitializerCode()
    }

    private fun aExpr2CodeBlock(aExpr: AExpr, module: Module, type: QualifiedType): InitializerCode {
        return when (aExpr) {
            is AExpr.AIntLiteral -> {
                literalCodeBlock(aExpr.value)
            }
            is AExpr.AUnitLiteral -> {
                literalCodeBlock("null")
            }
            is AExpr.ABoolLiteral -> {
                literalCodeBlock(aExpr == AExpr.ABoolLiteral.True)
            }
            is AExpr.ACharLiteral -> {
                literalCodeBlock(aExpr.value)
            }
            is AExpr.AStringLiteral -> {
                literalCodeBlock(""""${aExpr.value}"""")
            }
            is AExpr.AValueReference -> {
                if (aExpr.targetModule == module) {
                    literalCodeBlock(aExpr.reference)
                } else {
                    val className = ClassName.get(aExpr.targetModule.packageName, aExpr.targetModule.moduleName)
                    InitializerCode.InlineCode(CodeBlock.of("\$T.${aExpr.reference}", className))
                }
            }
            is AExpr.ANegation -> {
                val operandCode = aExpr2CodeBlock(aExpr.operand, module, BuiltInTypes.Bool)

                when (operandCode) {
                    is InitializerCode.InlineCode -> {
                        val code = CodeBlock.builder().add("!")

                        if (aExpr.operand.precedence() < aExpr.precedence()) {
                            code
                                    .add("(")
                                    .add(operandCode.code)
                                    .add(")")
                        } else {
                            code.add(operandCode.code)
                        }
                        InitializerCode.InlineCode(code.build())
                    }
                    is InitializerCode.BlockCode -> {
                        val code = CodeBlock.builder()
                                .add(operandCode.code)

                        val tmpVar = generateTemporary()
                        code.addStatement("boolean \$L = !\$L", tmpVar, operandCode.variable)

                        InitializerCode.BlockCode(code.build(), tmpVar)
                    }
                }
            }
            is AExpr.ADisjunction -> {
                handleBinaryOperation(aExpr.leftDisjunct, aExpr.rightDisjunct, module, "||", aExpr.precedence(),
                        BuiltInTypes.Bool, BuiltInTypes.Bool)
            }
            is AExpr.AConjunction -> {
                handleBinaryOperation(aExpr.leftConjunct, aExpr.rightConjunct, module, "&&", aExpr.precedence(),
                        BuiltInTypes.Bool, BuiltInTypes.Bool)
            }
            is AExpr.ALesser -> {
                handleBinaryOperation(aExpr.leftOperand, aExpr.rightOperand, module, "<", aExpr.precedence(),
                        BuiltInTypes.Bool, BuiltInTypes.Int)
            }
            is AExpr.ALesserEqual -> {
                handleBinaryOperation(aExpr.leftOperand, aExpr.rightOperand, module, "<=", aExpr.precedence(),
                        BuiltInTypes.Bool, BuiltInTypes.Int)
            }
            is AExpr.AGreater -> {
                handleBinaryOperation(aExpr.leftOperand, aExpr.rightOperand, module, ">", aExpr.precedence(),
                        BuiltInTypes.Bool, BuiltInTypes.Int)
            }
            is AExpr.AGreaterEqual -> {
                handleBinaryOperation(aExpr.leftOperand, aExpr.rightOperand, module, ">=", aExpr.precedence(),
                        BuiltInTypes.Bool, BuiltInTypes.Int)
            }
            is AExpr.AAddition -> {
                handleBinaryOperation(aExpr.augend, aExpr.addend, module, "+", aExpr.precedence(),
                        BuiltInTypes.Int, BuiltInTypes.Int)
            }
            is AExpr.AStringConcatenation -> {
                handleBinaryOperation(aExpr.leftOperand, aExpr.rightOperand, module, "+", aExpr.precedence(),
                        BuiltInTypes.String, BuiltInTypes.String)
            }
            is AExpr.ASubtraction -> {
                handleBinaryOperation(aExpr.minuend, aExpr.subtrahend, module, "-", aExpr.precedence(),
                        BuiltInTypes.Int, BuiltInTypes.Int)
            }
            is AExpr.AMultiplication -> {
                handleBinaryOperation(aExpr.multiplicand, aExpr.multiplier, module, "*", aExpr.precedence(),
                        BuiltInTypes.Int, BuiltInTypes.Int)
            }
            is AExpr.ADivision -> {
                handleBinaryOperation(aExpr.dividend, aExpr.divisor, module, "/", aExpr.precedence(),
                        BuiltInTypes.Int, BuiltInTypes.Int)
            }
            is AExpr.AModulus -> {
                handleBinaryOperation(aExpr.dividend, aExpr.divisor, module, "%", aExpr.precedence(),
                        BuiltInTypes.Int, BuiltInTypes.Int)
            }
            is AExpr.APrimitiveEquality -> {
                handleBinaryOperation(aExpr.leftOperand, aExpr.rightOperand, module, "==", aExpr.precedence(),
                        BuiltInTypes.Bool, aExpr.leftOperand.type())
            }
            is AExpr.APrimitiveInequality -> {
                handleBinaryOperation(aExpr.leftOperand, aExpr.rightOperand, module, "!=", aExpr.precedence(),
                        BuiltInTypes.Bool, aExpr.leftOperand.type())
            }
            is AExpr.AStringEquality -> {
                handleComparisonOperation(aExpr.leftOperand, aExpr.rightOperand, module, "", aExpr.precedence(),
                        BuiltInTypes.String)
            }
            is AExpr.AStringInequality -> {
                handleComparisonOperation(aExpr.leftOperand, aExpr.rightOperand, module, "!", aExpr.precedence(),
                        BuiltInTypes.String)
            }
            is AExpr.ALet -> {
                val code = CodeBlock.builder()

                // declare a temporary for the result of the expression
                val tmpVar = generateTemporary()
                code
                        .addStatement("\$T \$L", toJavaType(type), tmpVar)
                        .add("{\n")
                        .indent()

                // handle the declarations
                for (decl in aExpr.declarations) {
                    val initCode = when (decl) {
                        is ADef.AValueDef.ASimpleValueDef ->
                            aExpr2CodeBlock(decl.initializer, module, decl.type)
                    }
                    when (initCode) {
                        is InitializerCode.InlineCode -> {
                            code
                                    .add("\$T \$L = ", toJavaType(decl.type), decl.id)
                                    .add(initCode.code)
                                    .add(";\n")
                        }
                        is InitializerCode.BlockCode -> {
                            code
                                    .add(initCode.code)
                                    .addStatement("\$T \$L = \$L", toJavaType(decl.type), decl.id, initCode.variable)
                        }
                    }
                }

                // handle the expression
                val exprCode = aExpr2CodeBlock(aExpr.expr, module, type)
                when (exprCode) {
                    is InitializerCode.InlineCode -> {
                        code
                                .add("\$L = ", tmpVar)
                                .add(exprCode.code)
                                .add(";\n")
                    }
                    is InitializerCode.BlockCode -> {
                        code
                                .add(exprCode.code)
                                .addStatement("\$L = \$L", tmpVar, exprCode.variable)
                    }
                }

                code.endControlFlow()

                InitializerCode.BlockCode(code.build(), tmpVar)
            }
            is AExpr.AIf -> {
                val conditionBlock = aExpr2CodeBlock(aExpr.conditionExpr, module, aExpr.conditionExpr.type())
                val thenBlock = aExpr2CodeBlock(aExpr.thenExpr, module, aExpr.thenExpr.type())
                val elseBlock = aExpr2CodeBlock(aExpr.elseExpr, module, aExpr.elseExpr.type())

                val tmpVar = if (conditionBlock.isCodeABlock ||
                        thenBlock.isCodeABlock ||
                        elseBlock.isCodeABlock)
                    generateTemporary()
                else
                    null

                val code = CodeBlock.builder()

                if (tmpVar != null) {
                    code
                            .addStatement("\$T \$L", toJavaType(type), tmpVar)
                            .add("{\n")
                            .indent()
                }

                val conditionCode = CodeBlock.builder()
                when (conditionBlock) {
                    is InitializerCode.InlineCode -> {
                        conditionCode.add(conditionBlock.code)
                    }
                    is InitializerCode.BlockCode -> {
                        code.add(conditionBlock.code)
                        conditionCode.add("\$L", conditionBlock.variable)
                    }
                }
                val thenCode = CodeBlock.builder()
                when (thenBlock) {
                    is InitializerCode.InlineCode -> {
                        thenCode.add(thenBlock.code)
                    }
                    is InitializerCode.BlockCode -> {
                        code.add(thenBlock.code)
                        thenCode.add("\$L", thenBlock.variable)
                    }
                }
                val elseCode = CodeBlock.builder()
                when (elseBlock) {
                    is InitializerCode.InlineCode -> {
                        elseCode.add(elseBlock.code)
                    }
                    is InitializerCode.BlockCode -> {
                        code.add(elseBlock.code)
                        elseCode.add("\$L", elseBlock.variable)
                    }
                }

                if (tmpVar != null) {
                    code
                            .add("\$L = ", tmpVar)
                }

                code
                        .add(conditionCode.build())
                        .add(" ? ")
                        .add(thenCode.build())
                        .add(" : ")
                        .add(elseCode.build())

                if (tmpVar != null) {
                    code
                            .add(";\n")
                            .endControlFlow()
                }

                if (tmpVar == null) {
                    InitializerCode.InlineCode(code.build())
                } else {
                    InitializerCode.BlockCode(code.build(), tmpVar)
                }
            }
            is AExpr.ACall -> {
                throw Exception("Code generation for function calls has not been implemented yet")
            }
        }
    }

    private fun literalCodeBlock(value: Any): InitializerCode {
        return InitializerCode.InlineCode(CodeBlock.of("\$L", value))
    }

    private fun handleBinaryOperation(leftExpr: AExpr, rightExpr: AExpr, module: Module, operator: String,
            operatorPrecedence: Int, resultType: QualifiedType, operandType: QualifiedType): InitializerCode {
        val leftOperandInitializer = aExpr2CodeBlock(leftExpr, module, operandType)
        val rightOperandInitializer = aExpr2CodeBlock(rightExpr, module, operandType)

        val code = CodeBlock.builder()
        var anySideIsBlock = false

        val leftPrecedence: Int
        val leftOperandCode: CodeBlock
        when (leftOperandInitializer) {
            is InitializerCode.InlineCode -> {
                leftPrecedence = leftExpr.precedence()
                leftOperandCode = leftOperandInitializer.code
            }
            is InitializerCode.BlockCode -> {
                code.add(leftOperandInitializer.code)
                anySideIsBlock = true
                leftPrecedence = AExpr.AUnitLiteral.precedence()
                leftOperandCode = CodeBlock.of("\$L", leftOperandInitializer.variable)
            }
        }

        val rightPrecedence: Int
        val rightOperandCode: CodeBlock
        when (rightOperandInitializer) {
            is InitializerCode.InlineCode -> {
                rightPrecedence = rightExpr.precedence()
                rightOperandCode = rightOperandInitializer.code
            }
            is InitializerCode.BlockCode -> {
                code.add(rightOperandInitializer.code)
                anySideIsBlock = true
                rightPrecedence = AExpr.AUnitLiteral.precedence()
                rightOperandCode = CodeBlock.of("\$L", rightOperandInitializer.variable)
            }
        }

        val tmpVar: String?
        if (anySideIsBlock) {
            tmpVar = generateTemporary()
            code.add("\$T \$L = ", toJavaType(resultType), tmpVar)
        } else {
            tmpVar = null
        }

        if (leftPrecedence < operatorPrecedence) {
            code
                    .add("(")
                    .add(leftOperandCode)
                    .add(")")
        } else {
            code.add(leftOperandCode)
        }

        code.add(" $operator ")

        if (rightPrecedence <= operatorPrecedence) {
            code
                    .add("(")
                    .add(rightOperandCode)
                    .add(")")
        } else {
            code.add(rightOperandCode)
        }

        if (anySideIsBlock) {
            code.add(";\n")
        }

        return if (tmpVar == null)
            InitializerCode.InlineCode(code.build())
        else
            InitializerCode.BlockCode(code.build(), tmpVar)
    }

    private fun handleComparisonOperation(leftExpr: AExpr, rightExpr: AExpr, module: Module, prolog: String,
            operatorPrecedence: Int, operandType: QualifiedType): InitializerCode {
        val leftOperandInitializer = aExpr2CodeBlock(leftExpr, module, operandType)
        val rightOperandInitializer = aExpr2CodeBlock(rightExpr, module, operandType)

        val code = CodeBlock.builder()
        var anySideIsBlock = false

        val leftPrecedence: Int
        val leftOperandCode: CodeBlock
        when (leftOperandInitializer) {
            is InitializerCode.InlineCode -> {
                leftPrecedence = leftExpr.precedence()
                leftOperandCode = leftOperandInitializer.code
            }
            is InitializerCode.BlockCode -> {
                code.add(leftOperandInitializer.code)
                anySideIsBlock = true
                leftPrecedence = AExpr.AUnitLiteral.precedence()
                leftOperandCode = CodeBlock.of("\$L", leftOperandInitializer.variable)
            }
        }

        val rightOperandCode: CodeBlock
        when (rightOperandInitializer) {
            is InitializerCode.InlineCode -> {
                rightOperandCode = rightOperandInitializer.code
            }
            is InitializerCode.BlockCode -> {
                code.add(rightOperandInitializer.code)
                anySideIsBlock = true
                rightOperandCode = CodeBlock.of("\$L", rightOperandInitializer.variable)
            }
        }

        val tmpVar: String?
        if (anySideIsBlock) {
            tmpVar = generateTemporary()
            code.add("boolean \$L = ", tmpVar)
        } else {
            tmpVar = null
        }

        code.add(prolog)

        if (leftPrecedence < operatorPrecedence) {
            code
                    .add("(")
                    .add(leftOperandCode)
                    .add(")")
        } else {
            code.add(leftOperandCode)
        }

        code
                .add(".equals(")
                .add(rightOperandCode)
                .add(")")

        if (anySideIsBlock) {
            code.add(";\n")
        }

        return if (tmpVar == null)
            InitializerCode.InlineCode(code.build())
        else
            InitializerCode.BlockCode(code.build(), tmpVar)
    }

    private var counter: Int = 0

    private fun generateTemporary(): String {
        val ret = counter
        counter += 1
        return "\$tmp$ret"
    }

    private fun AExpr.precedence(): Int = when (this) {
        is AExpr.ALet -> 0
        is AExpr.AIf -> 0
        is AExpr.ADisjunction -> 1
        is AExpr.AConjunction -> 2
        is AExpr.APrimitiveEquality -> 3
        is AExpr.APrimitiveInequality -> 3
        is AExpr.ALesser -> 4
        is AExpr.ALesserEqual -> 4
        is AExpr.AGreater -> 4
        is AExpr.AGreaterEqual -> 4
        is AExpr.AAddition -> 5
        // String concatenation is the same as addition
        is AExpr.AStringConcatenation -> 5
        is AExpr.ASubtraction -> 5
        is AExpr.AMultiplication -> 6
        is AExpr.ADivision -> 6
        is AExpr.AModulus -> 6
        is AExpr.ANegation -> 7
        // because String inequality is implemented as !s1.equals(s2),
        // it has the same precedence as negation
        is AExpr.AStringInequality -> 7
        is AExpr.AStringEquality -> 8
        is AExpr.AIntLiteral -> 9
        is AExpr.AUnitLiteral -> 9
        is AExpr.ABoolLiteral -> 9
        is AExpr.ACharLiteral -> 9
        is AExpr.AStringLiteral -> 9
        is AExpr.AValueReference -> 9
        is AExpr.ACall -> throw Exception("precedence() for function calls has not been implemented yet")
    }

    private fun AExpr.type(): QualifiedType = when (this) {
        is AExpr.ADisjunction -> BuiltInTypes.Bool
        is AExpr.AConjunction -> BuiltInTypes.Bool
        is AExpr.APrimitiveEquality -> BuiltInTypes.Bool
        is AExpr.APrimitiveInequality -> BuiltInTypes.Bool
        is AExpr.ALesser -> BuiltInTypes.Bool
        is AExpr.ALesserEqual -> BuiltInTypes.Bool
        is AExpr.AGreater -> BuiltInTypes.Bool
        is AExpr.AGreaterEqual -> BuiltInTypes.Bool
        is AExpr.AAddition -> BuiltInTypes.Int
        is AExpr.AStringConcatenation -> BuiltInTypes.String
        is AExpr.ASubtraction -> BuiltInTypes.Int
        is AExpr.AMultiplication -> BuiltInTypes.Int
        is AExpr.ADivision -> BuiltInTypes.Int
        is AExpr.AModulus -> BuiltInTypes.Int
        is AExpr.ANegation -> BuiltInTypes.Bool
        is AExpr.AStringInequality -> BuiltInTypes.Bool
        is AExpr.AStringEquality -> BuiltInTypes.Bool
        is AExpr.AIntLiteral -> BuiltInTypes.Int
        is AExpr.AUnitLiteral -> BuiltInTypes.Unit
        is AExpr.ABoolLiteral -> BuiltInTypes.Bool
        is AExpr.ACharLiteral -> BuiltInTypes.Char
        is AExpr.AStringLiteral -> BuiltInTypes.String
        is AExpr.AValueReference -> this.type
        is AExpr.ALet -> this.expr.type()
        is AExpr.AIf -> this.thenExpr.type()
        is AExpr.ACall -> throw Exception("type() for function calls has not been implemented yet")
    }
}
