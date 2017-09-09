package org.fujure.fbc.analyze

import org.fujure.fbc.ast.AstRoot
import org.fujure.fbc.ast.SymbolTable

data class AnalyzedProgram(val asts: List<AstRoot>,
                           val symbolTable: SymbolTable)
