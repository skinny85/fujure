package org.fujure.fbc.parse.bnfc

import org.fujure.fbc.ast.TypeReference
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FragmSimpleType
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncTypeDesc
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleType
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleTypeDesc
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeDesc

internal object TypeDesc2TypeReference :
        TypeDesc.Visitor<TypeReference, Unit>,
        SimpleType.Visitor<TypeReference, Unit> {
    override fun visit(simpleTypeDesc: SimpleTypeDesc, arg: Unit): TypeReference {
        return simpleTypeDesc.simpletype_.accept(this, arg)
    }

    override fun visit(fragmSimpleType: FragmSimpleType, arg: Unit): TypeReference {
        return TypeReference(fragmSimpleType.listsimpletypefragm_.map { simpleTypeFragm ->
            simpleTypeFragm.accept({ idSimpleTypeFragm, _ -> idSimpleTypeFragm.jid_ }, arg)
        })
    }

    override fun visit(funcTypeDesc: FuncTypeDesc, arg: Unit): TypeReference {
        throw UnsupportedOperationException()
    }
}
