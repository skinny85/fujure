package org.fujure.fbc.codegen

import com.squareup.javapoet.ClassName
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

        var format = "\$L"
        val initializer: Any
        when (simpleValueDef.initializer) {
            is AExpr.AIntLiteral -> {
                initializer = simpleValueDef.initializer.value
            }
            is AExpr.AUnitLiteral -> {
                initializer = "null"
            }
            is AExpr.ABoolLiteral -> {
                initializer = simpleValueDef.initializer == AExpr.ABoolLiteral.True
            }
            is AExpr.ACharLiteral -> {
                initializer = simpleValueDef.initializer.value
            }
            is AExpr.AStringLiteral -> {
                initializer = """"${simpleValueDef.initializer.value}""""
            }
            is AExpr.AValueReferenceExpr -> {
                if (simpleValueDef.initializer.targetModule == module) {
                    initializer = simpleValueDef.initializer.reference
                } else {
                    initializer = ClassName.get(simpleValueDef.initializer.targetModule.packageName,
                            simpleValueDef.initializer.targetModule.moduleName)
                    format = "\$T.${simpleValueDef.initializer.reference}"
                }
            }
        }
        return FieldSpec.builder(variableType, simpleValueDef.id,
                Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                .initializer(format, initializer)
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
}
