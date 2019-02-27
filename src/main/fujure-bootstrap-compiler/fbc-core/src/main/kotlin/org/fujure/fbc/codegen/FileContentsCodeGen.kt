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
            else -> TODO()
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

        if (rightOperand.precedence() < operatorPrecedence) {
            code
                    .add("(")
                    .add(rightOperandCode)
                    .add(")")
        } else {
            code.add(rightOperandCode)
        }

        return code.build()
    }

    private fun AExpr.precedence(): Int = when (this) {
        is AExpr.ADisjunction -> 0
        is AExpr.AConjunction -> 1
        is AExpr.ANegation -> 2
        is AExpr.AIntLiteral -> 2
        is AExpr.AUnitLiteral -> 2
        is AExpr.ABoolLiteral -> 2
        is AExpr.ACharLiteral -> 2
        is AExpr.AStringLiteral -> 2
        is AExpr.AValueReference -> 2
        else -> TODO()
    }
}
