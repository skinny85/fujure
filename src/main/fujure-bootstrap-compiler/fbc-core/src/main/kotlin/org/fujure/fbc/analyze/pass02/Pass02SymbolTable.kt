package org.fujure.fbc.analyze.pass02

import org.fujure.fbc.ast.Expr
import org.fujure.fbc.ast.InputFile
import org.fujure.fbc.ast.Module
import org.fujure.fbc.ast.TypeReference

class Pass02SymbolTable(val modules: Map<Module, Pass02ModuleSymbols>)

class Pass02ModuleSymbols(val inputFile: InputFile,
        val simpleValues: Map<String, Pair<TypeReference?, Expr>>)
