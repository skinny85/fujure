package org.fujure.fbc.codegen.ast

import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.TypeSpec
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Defs
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage
import javax.lang.model.element.Modifier

object FileContentsCodegenVisitor : FileContents.Visitor<JavaFile, String> {
    override fun visit(fileContents: FileInNamedPackage, className: String): JavaFile {
        return javaFile(fileContents, fileContents.defs_, className)
    }

    override fun visit(fileContents: FileInDefaultPackage, className: String): JavaFile {
        return javaFile(fileContents, fileContents.defs_, className)
    }

    private fun javaFile(fileContents: FileContents, defs: Defs, className: String): JavaFile {
        return javaFileInPackage(defs, fileContents.accept(PackageNameExtractor, Unit), className)
    }

    private fun javaFileInPackage(defs: Defs, packageName: String, className: String): JavaFile {
        val typeSpecBuilder = TypeSpec.classBuilder(className)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)

        for (def in defs.accept({ definitions, _  -> definitions.listdef_ }, Unit)) {
            typeSpecBuilder.addField(def.accept({ definition, _ ->
                definition.valdef_.accept(ValDefCodegenVisitor, Unit)
            }, Unit))
        }

        return JavaFile
                .builder(packageName, typeSpecBuilder.build())
                .build()
    }
}
