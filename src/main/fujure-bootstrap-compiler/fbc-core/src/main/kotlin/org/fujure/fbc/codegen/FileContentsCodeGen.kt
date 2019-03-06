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

object FileContentsCodeGen {
    fun generate(annotatedAst: AFileContents): JavaFile {
        val typeSpecBuilder = TypeSpec.classBuilder(annotatedAst.module.moduleName)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)

        for (def in annotatedAst.defs) {
            when (def) {
                is ADef.AValueDef.ASimpleValueDef ->
                    typeSpecBuilder.addField(generateField(def, annotatedAst.module))
            }
        }

        return JavaFile
                .builder(annotatedAst.module.packageName, typeSpecBuilder.build())
                .skipJavaLangImports(true)
                .build()
    }

    private fun generateField(simpleValueDef: ADef.AValueDef.ASimpleValueDef, module: Module): FieldSpec {
        val variableType = toJavaType(simpleValueDef.type)!!
        val initializerCodeBlock = aExpr2CodeBlock(simpleValueDef.initializer, module)
        return FieldSpec.builder(variableType, simpleValueDef.id,
                Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                .initializer(initializerCodeBlock)
                .build()
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

    private fun aExpr2CodeBlock(aExpr: AExpr, module: Module): CodeBlock {
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
                    CodeBlock.of("\$T.${aExpr.reference}", className)
                }
            }
            is AExpr.ANegation -> {
                val operandCode = aExpr2CodeBlock(aExpr.operand, module)

                val code = CodeBlock.builder().add("!")

                if (aExpr.operand.precedence() < aExpr.precedence()) {
                    code
                            .add("(")
                            .add(operandCode)
                            .add(")")
                } else {
                    code.add(operandCode)
                }
                code.build()
            }
            is AExpr.ADisjunction -> {
                handleBinaryOperation(aExpr.leftDisjunct, aExpr.rightDisjunct, module, "||", aExpr.precedence())
            }
            is AExpr.AConjunction -> {
                handleBinaryOperation(aExpr.leftConjunct, aExpr.rightConjunct, module, "&&", aExpr.precedence())
            }
            is AExpr.ALesser -> {
                handleBinaryOperation(aExpr.leftOperand, aExpr.rightOperand, module, "<", aExpr.precedence())
            }
            is AExpr.ALesserEqual -> {
                handleBinaryOperation(aExpr.leftOperand, aExpr.rightOperand, module, "<=", aExpr.precedence())
            }
            is AExpr.AGreater -> {
                handleBinaryOperation(aExpr.leftOperand, aExpr.rightOperand, module, ">", aExpr.precedence())
            }
            is AExpr.AGreaterEqual -> {
                handleBinaryOperation(aExpr.leftOperand, aExpr.rightOperand, module, ">=", aExpr.precedence())
            }
            is AExpr.AAddition -> {
                handleBinaryOperation(aExpr.augend, aExpr.addend, module, "+", aExpr.precedence())
            }
            is AExpr.ASubtraction -> {
                handleBinaryOperation(aExpr.minuend, aExpr.subtrahend, module, "-", aExpr.precedence())
            }
            is AExpr.AMultiplication -> {
                handleBinaryOperation(aExpr.multiplicand, aExpr.multiplier, module, "*", aExpr.precedence())
            }
            is AExpr.ADivision -> {
                handleBinaryOperation(aExpr.dividend, aExpr.divisor, module, "/", aExpr.precedence())
            }
            is AExpr.AModulus -> {
                handleBinaryOperation(aExpr.dividend, aExpr.divisor, module, "%", aExpr.precedence())
            }
            is AExpr.APrimitiveEquality -> {
                handleBinaryOperation(aExpr.leftOperand, aExpr.rightOperand, module, "==", aExpr.precedence())
            }
            is AExpr.APrimitiveInequality -> {
                handleBinaryOperation(aExpr.leftOperand, aExpr.rightOperand, module, "!=", aExpr.precedence())
            }
            is AExpr.AStringEquality -> {
                handleEqualityOperation(aExpr.leftOperand, aExpr.rightOperand, module, "", aExpr.precedence())
            }
            is AExpr.AStringInequality -> {
                handleEqualityOperation(aExpr.leftOperand, aExpr.rightOperand, module, "!", aExpr.precedence())
            }
        }
    }

    private fun literalCodeBlock(value: Any): CodeBlock {
        return CodeBlock.of("\$L", value)
    }

    private fun handleBinaryOperation(leftOperand: AExpr, rightOperand: AExpr, module: Module, operator: String,
            operatorPrecedence: Int): CodeBlock {
        val leftOperandCode = aExpr2CodeBlock(leftOperand, module)
        val rightOperandCode = aExpr2CodeBlock(rightOperand, module)

        val code = CodeBlock.builder()

        if (leftOperand.precedence() < operatorPrecedence) {
            code
                    .add("(")
                    .add(leftOperandCode)
                    .add(")")
        } else {
            code.add(leftOperandCode)
        }

        code.add(" $operator ")

        if (rightOperand.precedence() <= operatorPrecedence) {
            code
                    .add("(")
                    .add(rightOperandCode)
                    .add(")")
        } else {
            code.add(rightOperandCode)
        }

        return code.build()
    }

    private fun handleEqualityOperation(leftExpr: AExpr, rightExpr: AExpr, module: Module, prolog: String,
            operatorPrecedence: Int): CodeBlock {
        val leftOperandCode = aExpr2CodeBlock(leftExpr, module)
        val rightOperandCode = aExpr2CodeBlock(rightExpr, module)

        val code = CodeBlock.builder()

        code.add(prolog)

        if (leftExpr.precedence() < operatorPrecedence) {
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

        return code.build()
    }

    private fun AExpr.precedence(): Int = when (this) {
        is AExpr.ADisjunction -> 0
        is AExpr.AConjunction -> 1
        is AExpr.APrimitiveEquality -> 2
        is AExpr.APrimitiveInequality -> 2
        is AExpr.ALesser -> 3
        is AExpr.ALesserEqual -> 3
        is AExpr.AGreater -> 3
        is AExpr.AGreaterEqual -> 3
        is AExpr.AAddition -> 4
        is AExpr.ASubtraction -> 4
        is AExpr.AMultiplication -> 5
        is AExpr.ADivision -> 5
        is AExpr.AModulus -> 5
        is AExpr.ANegation -> 6
        // because String inequality is implemented as !s1.equals(s2),
        // it has the same precedence as negation
        is AExpr.AStringInequality -> 6
        is AExpr.AStringEquality -> 7
        is AExpr.AIntLiteral -> 8
        is AExpr.AUnitLiteral -> 8
        is AExpr.ABoolLiteral -> 8
        is AExpr.ACharLiteral -> 8
        is AExpr.AStringLiteral -> 8
        is AExpr.AValueReference -> 8
    }
}
