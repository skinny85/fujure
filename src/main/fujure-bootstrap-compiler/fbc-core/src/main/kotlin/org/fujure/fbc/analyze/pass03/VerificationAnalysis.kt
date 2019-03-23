package org.fujure.fbc.analyze.pass03

import org.fujure.fbc.ProblematicFile.SemanticFileIssue
import org.fujure.fbc.aast.ADef
import org.fujure.fbc.aast.AFileContents
import org.fujure.fbc.analyze.SemanticError
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.Module
import org.fujure.fbc.ast.ValueCoordinates
import org.fujure.fbc.parse.ParsedFile
import org.funktionale.either.Disjunction

object VerificationAnalysis {
    fun analyze(parsedFiles: Set<ParsedFile>, symbolTable: Pass03SymbolTable):
            Pair<List<AFileContents>, List<SemanticFileIssue>> {
        val problematicFiles = mutableListOf<SemanticFileIssue>()
        val aAsts = mutableListOf<AFileContents>()

        for (parsedFile in parsedFiles) {
            val fileContentsOrIssue = analyzeFile(parsedFile, symbolTable)
            when (fileContentsOrIssue) {
                is Disjunction.Left -> problematicFiles.add(fileContentsOrIssue.value)
                is Disjunction.Right -> aAsts.add(fileContentsOrIssue.value)
            }
        }

        return Pair(aAsts, problematicFiles)
    }

    private fun analyzeFile(parsedFile: ParsedFile, symbolTable: Pass03SymbolTable):
            Disjunction<SemanticFileIssue, AFileContents> {
        val errors = mutableListOf<SemanticError>()
        val aDefs = mutableListOf<ADef>()

        val module = parsedFile.module()

        // handle definitions
        for (def in parsedFile.ast.defs) {
            val defOrErrors = analyzeDefinition(def, symbolTable, module)
            when (defOrErrors) {
                is Disjunction.Left -> {
                    errors.addAll(defOrErrors.value)
                }
                is Disjunction.Right -> {
                    val aDef = defOrErrors.value
                    if (aDef != null)
                        aDefs.add(aDef)
                }
            }
        }

        return if (errors.isEmpty())
            Disjunction.Right(AFileContents(parsedFile.inputFile, module, aDefs))
        else
            Disjunction.Left(SemanticFileIssue(parsedFile.inputFile.userProvidedFilePath, errors))
    }

    private fun analyzeDefinition(def: Def, symbolTable: Pass03SymbolTable, module: Module):
            Disjunction<List<SemanticError>, ADef?> {
        return when (def) {
            is Def.ValueDef.SimpleValueDef -> {
                ValueDeclarationVerifier(symbolTable, module, def.id,
                        listOf(ValueCoordinates(module.packageName, module.moduleName, def.id))).analyzeValueDeclaration(def)
            }
        }
    }
}
