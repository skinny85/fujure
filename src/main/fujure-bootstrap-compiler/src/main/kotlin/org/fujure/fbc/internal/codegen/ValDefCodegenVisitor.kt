package org.fujure.fbc.internal.codegen

import com.squareup.javapoet.FieldSpec
import org.fujure.fbc.bnfc.antlr.Fujure.Absyn.ValDef
import org.fujure.fbc.bnfc.antlr.Fujure.Absyn.ValueDef
import javax.lang.model.element.Modifier

object ValDefCodegenVisitor : ValDef.Visitor<FieldSpec, Unit> {
    override fun visit(valueDef: ValueDef, arg: Unit): FieldSpec {
        return FieldSpec.builder(Integer.TYPE, valueDef.ident_,
                Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                .initializer("\$L", valueDef.integer_)
                .build()
    }
}
