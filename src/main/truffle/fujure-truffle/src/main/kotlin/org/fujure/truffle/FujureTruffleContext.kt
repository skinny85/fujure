package org.fujure.truffle;

import com.oracle.truffle.api.Scope
import com.oracle.truffle.api.frame.VirtualFrame
import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.ast.TypeReference
import org.fujure.fbc.ast.ValueReference
import org.fujure.truffle.nodes.ModuleNode

class FujureTruffleContext {
    private val symbolTable = SymbolTable()
    private val topScopes = setOf<Scope>(
            Scope
                    .newBuilder("global", symbolTable.fujureTruffleBindings)
                    .build())

    fun load(moduleNode: ModuleNode, frame: VirtualFrame): LoadModuleResult {
        return symbolTable.load(moduleNode, frame)
    }

    fun phase1Lookup(reference: ValueReference): Phase1LookupResult {
        return symbolTable.phase1Lookup(reference)
    }

    fun phase2Lookup(reference: ValueReference): Any? {
        return symbolTable.phase2Lookup(reference)
    }

    fun findType(typeReference: TypeReference): QualifiedType? {
        return symbolTable.findType(typeReference)
    }

    fun findTopScopes(): Iterable<Scope> {
        return topScopes
    }
}
