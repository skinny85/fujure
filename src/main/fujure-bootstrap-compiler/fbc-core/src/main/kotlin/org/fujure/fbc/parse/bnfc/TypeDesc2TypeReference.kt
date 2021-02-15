package org.fujure.fbc.parse.bnfc

import org.fujure.fbc.ast.TypeName
import org.fujure.fbc.ast.TypeReference
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FragmSimpleType
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncFuncTypeFragm
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncType
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncTypeDesc
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncTypeFragm
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GenericSimpleType
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GenericTypeDescValue
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GenericTypeValue
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.MultiArgFuncType
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleFuncTypeFragm
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleType
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleTypeDesc
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleTypeFragm
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.TypeDesc
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ZeroArgFuncType

internal object TypeDesc2TypeReference :
        TypeDesc.Visitor<TypeReference, Unit>,
        FuncType.Visitor<TypeReference.FunctionType, Unit>,
        FuncTypeFragm.Visitor<TypeReference, Unit>,
        SimpleType.Visitor<TypeReference.SimpleType, Unit>,
        GenericTypeValue.Visitor<TypeReference, Unit> {
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
        return simpleType2TypeReference(fragmSimpleType.listsimpletypefragm_)
    }

    override fun visit(genericSimpleType: GenericSimpleType, arg: Unit): TypeReference.SimpleType {
        return simpleType2TypeReference(genericSimpleType.listsimpletypefragm_,
                genericSimpleType.listgenerictypevalue_.map { genericTypeValue -> genericTypeValue.accept(this, arg) })
    }

    override fun visit(genericTypeDescValue: GenericTypeDescValue, arg: Unit): TypeReference {
        return genericTypeDescValue.typedesc_.accept(this, arg)
    }

    private fun simpleType2TypeReference(simpleTypeFragments: List<SimpleTypeFragm>,
            genericTypes: List<TypeReference> = listOf()): TypeReference.SimpleType {
        return TypeReference.SimpleType(TypeName(simpleTypeFragments.map { simpleTypeFragm ->
            simpleTypeFragm.accept({ idSimpleTypeFragm, _ -> idSimpleTypeFragm.jid_ }, Unit)
        }), genericTypes)
    }
}
