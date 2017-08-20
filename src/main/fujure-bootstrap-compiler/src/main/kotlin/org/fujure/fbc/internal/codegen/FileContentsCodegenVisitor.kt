package org.fujure.fbc.internal.codegen

import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.TypeSpec
import org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileContents
import org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage
import org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileInNamedPackage
import org.fujure.fbc.bnfc.antlr.Fujure.Absyn.ValDef
import javax.lang.model.element.Modifier

object FileContentsCodegenVisitor : FileContents.Visitor<TypeSpec, String> {
    override fun visit(fileContents: FileInNamedPackage, className: String): TypeSpec {
        return typeSpec(fileContents.valdef_, className)
    }

    override fun visit(fileContents: FileInDefaultPackage, className: String): TypeSpec {
        return typeSpec(fileContents.valdef_, className)
    }

    private fun typeSpec(valDef: ValDef, className: String): TypeSpec {
        return valDef.accept({ valueDef, _ ->
            TypeSpec.classBuilder(className)
                    .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                    .addField(FieldSpec.builder(Integer.TYPE, valueDef.ident_,
                            Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                            .initializer("\$L", valueDef.integer_)
                            .build())
                    .build()
        }, 0)
    }
}
