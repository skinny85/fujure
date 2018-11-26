package org.fujure.truffle

import org.fujure.fbc.analyze.SemanticError

sealed class LoadModuleResult {
    class Success(val moduleSymbolTable: ModuleSymbolTable) : LoadModuleResult()

    class Failure(val errors: List<SemanticError>) : LoadModuleResult()
}
