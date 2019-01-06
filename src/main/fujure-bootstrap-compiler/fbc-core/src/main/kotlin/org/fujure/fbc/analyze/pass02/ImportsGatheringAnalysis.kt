package org.fujure.fbc.analyze.pass02

import org.fujure.fbc.ProblematicFile.SemanticFileIssue
import org.fujure.fbc.analyze.SemanticError
import org.fujure.fbc.analyze.pass03.Pass03ModuleSymbols
import org.fujure.fbc.analyze.pass03.Pass03SymbolTable
import org.fujure.fbc.ast.Module
import org.fujure.fbc.parse.ParsedFile

object ImportsGatheringAnalysis {
    fun analyze(parsedFiles: Set<ParsedFile>, symbolTable: Pass02SymbolTable):
            Pair<Pass03SymbolTable, List<SemanticFileIssue>> {
        val issues = mutableListOf<SemanticFileIssue>()
        val modules = mutableMapOf<Module, Pass03ModuleSymbols>()

        for (parsedFile in parsedFiles) {
            val (pass02ModuleSymbols, errors) = analyzeFile(parsedFile, symbolTable)
            modules.putIfAbsent(parsedFile.module(), pass02ModuleSymbols)

            if (errors.isNotEmpty()) {
                issues.add(SemanticFileIssue(parsedFile.inputFile.userProvidedFilePath, errors))
            }
        }

        return Pair(Pass03SymbolTable(modules, symbolTable.symbolTable), issues)
    }

    private fun analyzeFile(parsedFile: ParsedFile, symbolTable: Pass02SymbolTable):
            Pair<Pass03ModuleSymbols, List<SemanticError>> {
        val errors = mutableListOf<SemanticError>()
        val imports = mutableMapOf<String, Module?>()

        for (imprt in parsedFile.ast.imports) {
            if (imprt.size == 1) {
                // ToDo handle default package imports correctly
                // (verify the module exists, return a distinct error)
                errors.add(SemanticError.UnresolvedImport(imprt))
                imports[imprt.lastFragment()] = null
            } else {
                val module = Module(imprt.allButLastFragments(), imprt.lastFragment())
                val moduleFound = symbolTable.find(module)
                if (moduleFound) {
                    // ToDo handle imports with the same module name
                    imports[imprt.lastFragment()] = module
                } else {
                    errors.add(SemanticError.UnresolvedImport(imprt))
                    imports[imprt.lastFragment()] = null
                }
            }
        }

        val moduleSymbols = symbolTable.modules[parsedFile.module()]!!
        return Pair(
                Pass03ModuleSymbols(imports, moduleSymbols.simpleValues),
                errors)
    }
}
