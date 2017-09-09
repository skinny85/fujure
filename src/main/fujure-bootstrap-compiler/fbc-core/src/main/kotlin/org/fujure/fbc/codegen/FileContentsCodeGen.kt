package org.fujure.fbc.codegen

import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.TypeSpec
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.FileContents
import org.fujure.fbc.ast.SymbolTable
import javax.lang.model.element.Modifier

object FileContentsCodeGen {
    fun generate(fileContents: FileContents, className: String, symbolTable: SymbolTable): JavaFile {
        val typeSpecBuilder = TypeSpec.classBuilder(className)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)

        for (def in fileContents.defs) {
            when (def) {
                is Def.ValueDef.SimpleValueDef ->
                    typeSpecBuilder.addField(FieldSpec.builder(Integer.TYPE, def.id,
                            Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                            .initializer("\$L", def.value)
                            .build())
            }
        }

        return JavaFile
                .builder(fileContents.packageName, typeSpecBuilder.build())
                .build()
    }
}
