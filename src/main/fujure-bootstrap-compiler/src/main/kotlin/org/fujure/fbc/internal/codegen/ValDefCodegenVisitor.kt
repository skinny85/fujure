package org.fujure.fbc.internal.codegen

import com.squareup.javapoet.FieldSpec
import org.fujure.fbc.bnfc.antlr.Fujure.Absyn.TypedValueDef
import org.fujure.fbc.bnfc.antlr.Fujure.Absyn.UntypedValueDef
import org.fujure.fbc.bnfc.antlr.Fujure.Absyn.ValDef
import javax.lang.model.element.Modifier

object ValDefCodegenVisitor : ValDef.Visitor<FieldSpec, Unit> {
    override fun visit(valueDef: UntypedValueDef, arg: Unit): FieldSpec {
        return generateField(valueDef.ident_, valueDef.integer_)
    }

    override fun visit(valueDef: TypedValueDef, arg: Unit): FieldSpec {
        return generateField(valueDef.ident_, valueDef.integer_)
    }

    private fun generateField(valueName: String, valueInitializer: Int): FieldSpec {
        return FieldSpec.builder(Integer.TYPE, valueName,
                Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                .initializer("\$L", valueInitializer)
                .build()
    }
}
