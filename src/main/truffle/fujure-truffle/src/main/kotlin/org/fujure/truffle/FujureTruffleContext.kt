package org.fujure.truffle;

import com.oracle.truffle.api.Scope
import com.oracle.truffle.api.frame.VirtualFrame
import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.ast.TypeReference
import org.fujure.fbc.ast.ValueReference
import org.fujure.truffle.nodes.ModuleNode

class FujureTruffleContext {
    private val symbolTable = SymbolTable()
    private val fujureTruffleBindings = FujureTruffleBindings()
    private val topScopes = setOf<Scope>(
            Scope
                    .newBuilder("global", fujureTruffleBindings)
                    .build())

    fun load(moduleNode: ModuleNode, frame: VirtualFrame): LoadModuleResult {
        val loadModuleResult = symbolTable.load(moduleNode, frame)
        if (loadModuleResult is LoadModuleResult.Success) {
            val fqn = moduleNode.fullyQualifiedModuleName()
            fujureTruffleBindings.register(fqn, loadModuleResult.moduleSymbolTable)
        }
        return loadModuleResult
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
