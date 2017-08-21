package org.fujure.fbc.internal.codegen

import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.TypeSpec
import org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileContents
import org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage
import org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileInNamedPackage
import org.fujure.fbc.bnfc.antlr.Fujure.Absyn.ValDef
import javax.lang.model.element.Modifier

object FileContentsCodegenVisitor : FileContents.Visitor<JavaFile, String> {
    override fun visit(fileContents: FileInNamedPackage, className: String): JavaFile {
        return javaFile(fileContents.valdef_, className)
    }

    override fun visit(fileContents: FileInDefaultPackage, className: String): JavaFile {
        return javaFile(fileContents.valdef_, className)
    }

    private fun javaFile(valDef: ValDef, className: String): JavaFile {
        return valDef.accept({ valueDef, _ ->
            JavaFile.builder("", TypeSpec.classBuilder(className)
                    .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                    .addField(FieldSpec.builder(Integer.TYPE, valueDef.ident_,
                            Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                            .initializer("\$L", valueDef.integer_)
                            .build())
                    .build())
                    .build()
        }, 0)
    }
}
