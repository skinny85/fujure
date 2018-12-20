package org.fujure.fbc.analyze.pass01

import org.fujure.fbc.ast.Expr
import org.fujure.fbc.ast.InputFile
import org.fujure.fbc.ast.Module
import org.fujure.fbc.ast.TypeReference

class Pass01SymbolTable(val modules: Map<Module, Pass01ModuleSymbols>)

class Pass01ModuleSymbols(val inputFile: InputFile,
        val simpleValues: Map<String, Pair<TypeReference?, Expr>>)
