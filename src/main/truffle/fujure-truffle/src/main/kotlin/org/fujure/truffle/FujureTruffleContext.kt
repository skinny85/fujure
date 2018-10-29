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

    fun lookup(reference: ValueReference): LookupResult {
        return symbolTable.lookup(reference)
    }

    fun findType(typeReference: TypeReference): QualifiedType? {
        return symbolTable.findType(typeReference)
    }

    fun establishTypeOfValue(value: Any): QualifiedType? {
        return symbolTable.establishTypeOfValue(value)
    }

    fun findTopScopes(): Iterable<Scope> {
        return topScopes
    }
}
