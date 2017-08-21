package org.fujure.fbc.internal.codegen

import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.TypeSpec
import org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileContents
import org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage
import org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileInNamedPackage
import org.fujure.fbc.bnfc.antlr.Fujure.Absyn.ValDef
import org.fujure.fbc.internal.ast.PackageNameExtractor
import javax.lang.model.element.Modifier

object FileContentsCodegenVisitor : FileContents.Visitor<JavaFile, String> {
    override fun visit(fileContents: FileInNamedPackage, className: String): JavaFile {
        return javaFile(fileContents, fileContents.listvaldef_, className)
    }

    override fun visit(fileContents: FileInDefaultPackage, className: String): JavaFile {
        return javaFile(fileContents, fileContents.listvaldef_, className)
    }

    private fun javaFile(fileContents: FileContents, valDefs: List<ValDef>, className: String): JavaFile {
        return javaFileInPackage(valDefs, fileContents.accept(PackageNameExtractor, Unit), className)
    }

    private fun javaFileInPackage(valDefs: List<ValDef>, packageName: String, className: String): JavaFile {
        val typeSpecBuilder = TypeSpec.classBuilder(className)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)

        for (valDef in valDefs) {
            typeSpecBuilder.addField(valDef.accept(ValDefCodegenVisitor, Unit))
        }

        return JavaFile
                .builder(packageName, typeSpecBuilder.build())
                .build()
    }
}
