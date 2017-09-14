package org.fujure.fbc.analyze.pass_01

import org.fujure.fbc.ast.TypeReference
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpec
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecifier

object TypeSpec2TypeReference : TypeSpec.Visitor<TypeReference, Unit> {
    override fun visit(typeSpecifier: TypeSpecifier, arg: Unit): TypeReference {
        return TypeReference(typeSpecifier.listtypespecfragm_.map { typeSpecFragm ->
            typeSpecFragm.accept({ typeSpecFragment, _ -> typeSpecFragment.jid_ }, Unit)
        })
    }
}
