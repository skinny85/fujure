package org.fujure.fbc.analyze.pass01

import org.fujure.fbc.ProblematicFile.SemanticFileIssue
import org.fujure.fbc.analyze.SemanticError
import org.fujure.fbc.analyze.SymbolTable
import org.fujure.fbc.analyze.pass02.Pass02ModuleSymbols
import org.fujure.fbc.analyze.pass02.Pass02SymbolTable
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.Expr
import org.fujure.fbc.ast.Module
import org.fujure.fbc.ast.TypeReference
import org.fujure.fbc.common.NameValidator
import org.fujure.fbc.parse.ParsedFile

object SymbolsGatheringAnalysis {
    fun analyze(parsedFiles: Set<ParsedFile>, symbolTable: SymbolTable?):
            Pair<Pass02SymbolTable, List<SemanticFileIssue>> {
        val modules = mutableMapOf<Module, Pass02ModuleSymbols>()
        val issues = mutableListOf<SemanticFileIssue>()

        for (parsedFile in parsedFiles) {
            val semanticErrors = mutableListOf<SemanticError>()

            val fileSymbolsGatheringResult = analyzeFile(parsedFile)
            semanticErrors.addAll(fileSymbolsGatheringResult.second)

            val module = parsedFile.module()
            val previous = modules.putIfAbsent(module, fileSymbolsGatheringResult.first)
            if (previous != null) {
                semanticErrors.add(SemanticError.DuplicateModule(
                    module.packageName, module.moduleName, previous.inputFile, parsedFile.inputFile))
            }

            if (semanticErrors.isNotEmpty()) {
                issues.add(SemanticFileIssue(parsedFile.inputFile.userProvidedFilePath, semanticErrors))
            }
        }

        return Pair(Pass02SymbolTable(modules, symbolTable), issues)
    }

    private fun analyzeFile(parsedFile: ParsedFile): Pair<Pass02ModuleSymbols, List<SemanticError>> {
        val simpleValues = linkedMapOf<String, Pair<TypeReference?, Expr>>()
        val errors = mutableListOf<SemanticError>()

        for (def in parsedFile.ast.defs) {
            when (def) {
                is Def.ValueDef.SimpleValueDef -> {
                    val id = def.id
                    if (!NameValidator.validValueName(id))
                        errors.add(SemanticError.InvalidName(id))
                    if (simpleValues.putIfAbsent(id, Pair(def.declaredType, def.initializer)) != null)
                        errors.add(SemanticError.DuplicateDefinition(id))
                }
            }
        }

        return Pair(Pass02ModuleSymbols(parsedFile.inputFile, simpleValues), errors)
    }
}
