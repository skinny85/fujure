package org.fujure.fbc.codegen

import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.TypeSpec
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.Expr
import org.fujure.fbc.ast.FileContents
import org.fujure.fbc.ast.SymbolTable
import java.lang.reflect.Type
import javax.lang.model.element.Modifier

object FileContentsCodeGen {
    fun generate(fileContents: FileContents, className: String, symbolTable: SymbolTable): JavaFile {
        val typeSpecBuilder = TypeSpec.classBuilder(className)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)

        for (def in fileContents.defs) {
            when (def) {
                is Def.ValueDef.SimpleValueDef ->
                    typeSpecBuilder.addField(generateField(def, symbolTable))
            }
        }

        return JavaFile
                .builder(fileContents.packageName, typeSpecBuilder.build())
                .build()
    }

    private fun generateField(simpleValueDef: Def.ValueDef.SimpleValueDef, symbolTable: SymbolTable): FieldSpec {
        val variableType: Type
        val initializer: Any
        when (simpleValueDef.initializer) {
            is Expr.IntLiteral -> {
                variableType = Integer.TYPE
                initializer = simpleValueDef.initializer.value
            }
            is Expr.BoolLiteral -> {
                variableType = java.lang.Boolean.TYPE
                initializer = simpleValueDef.initializer == Expr.BoolLiteral.True
            }
        }
        return FieldSpec.builder(variableType, simpleValueDef.id,
                Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                .initializer("\$L", initializer)
                .build()
    }
}
