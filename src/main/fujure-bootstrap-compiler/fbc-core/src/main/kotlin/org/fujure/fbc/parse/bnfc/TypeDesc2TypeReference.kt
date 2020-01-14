package org.fujure.fbc.parse.bnfc

import org.fujure.fbc.ast.TypeReference
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FragmSimpleType
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncFuncTypeFragm
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncType
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncTypeDesc
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncTypeFragm
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MultiArgFuncType
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleFuncTypeFragm
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleType
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleTypeDesc
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeDesc
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ZeroArgFuncType

internal object TypeDesc2TypeReference :
        TypeDesc.Visitor<TypeReference, Unit>,
        FuncType.Visitor<TypeReference.FunctionType, Unit>,
        FuncTypeFragm.Visitor<TypeReference, Unit>,
        SimpleType.Visitor<TypeReference.SimpleType, Unit> {
    override fun visit(simpleTypeDesc: SimpleTypeDesc, arg: Unit): TypeReference {
        return simpleTypeDesc.simpletype_.accept(this, arg)
    }

    override fun visit(funcTypeDesc: FuncTypeDesc, arg: Unit): TypeReference {
        return funcTypeDesc.functype_.accept(this, arg)
    }

    override fun visit(zeroArgFuncType: ZeroArgFuncType, arg: Unit): TypeReference.FunctionType {
        return TypeReference.FunctionType(zeroArgFuncType.functypefragm_.accept(this, arg), emptyList())
    }

    override fun visit(multiArgFuncType: MultiArgFuncType, arg: Unit): TypeReference.FunctionType {
        val allButFirstTypes = multiArgFuncType.listfunctypefragm_.map { it.accept(this, arg) }
        return TypeReference.FunctionType(
                allButFirstTypes.last(),
                listOf(multiArgFuncType.functypefragm_.accept(this, arg)) +
                        allButFirstTypes.subList(0, allButFirstTypes.size - 1))
    }

    override fun visit(funcFuncTypeFragm: FuncFuncTypeFragm, arg: Unit): TypeReference {
        return funcFuncTypeFragm.functype_.accept(this, arg)
    }

    override fun visit(simpleFuncTypeFragm: SimpleFuncTypeFragm, arg: Unit): TypeReference {
        return simpleFuncTypeFragm.simpletype_.accept(this, arg)
    }

    override fun visit(fragmSimpleType: FragmSimpleType, arg: Unit): TypeReference.SimpleType {
        return TypeReference.SimpleType(fragmSimpleType.listsimpletypefragm_.map { simpleTypeFragm ->
            simpleTypeFragm.accept({ idSimpleTypeFragm, _ -> idSimpleTypeFragm.jid_ }, arg)
        })
    }
}
