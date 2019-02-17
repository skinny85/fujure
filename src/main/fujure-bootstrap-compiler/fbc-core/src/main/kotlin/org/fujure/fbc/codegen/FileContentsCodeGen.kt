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
            is AExpr.AValueReferenceExpr -> {
                if (aExpr.targetModule == module) {
                    literalCodeBlock(aExpr.reference)
                } else {
                    val className = ClassName.get(aExpr.targetModule.packageName, aExpr.targetModule.moduleName)
                    CodeBlock.of("\$T.${aExpr.reference}", className)
                }
            }
            is AExpr.ANegation -> {
                val operandCode = aExpr2CodeBlock(aExpr.operand, module)
                CodeBlock.builder()
                        .add("!")
                        .add(operandCode)
                        .build()
            }
            else -> {
                TODO()
            }
        }
    }

    private fun literalCodeBlock(value: Any): CodeBlock {
        return CodeBlock.of("\$L", value)
    }
}
