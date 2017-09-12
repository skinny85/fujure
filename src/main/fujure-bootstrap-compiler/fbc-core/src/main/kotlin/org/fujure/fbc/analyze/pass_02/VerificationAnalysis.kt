package org.fujure.fbc.analyze.pass_02

import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.analyze.AnalyzedProgram
import org.fujure.fbc.analyze.BuiltInTypes
import org.fujure.fbc.analyze.SemanticAnalysisResult
import org.fujure.fbc.analyze.SemanticError
import org.fujure.fbc.analyze.TypeErrorContext
import org.fujure.fbc.ast.AstRoot
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.SymbolTable
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Def as AbsynDef
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents as AbsynFileContents

object VerificationAnalysis {
    fun analyze(asts: List<AstRoot>, symbolTable: SymbolTable): SemanticAnalysisResult {
        val problematicFiles = mutableListOf<ProblematicFile.SemanticFileIssue>()
        for (ast in asts) {
            val problematicFile = analyze(ast, symbolTable)
            if (problematicFile != null)
                problematicFiles.add(problematicFile)
        }
        return if (problematicFiles.isEmpty())
            SemanticAnalysisResult.Success(AnalyzedProgram(asts, symbolTable))
        else
            SemanticAnalysisResult.Failure(problematicFiles)
    }

    private fun analyze(ast: AstRoot, symbolTable: SymbolTable): ProblematicFile.SemanticFileIssue? {
        val errors = mutableListOf<SemanticError>()
        for (def in ast.fileContents.defs) {
            val defErrors = analyze(def, symbolTable)
            errors.addAll(defErrors)
        }
        return if (errors.isEmpty())
            null
        else
            ProblematicFile.SemanticFileIssue(ast.userProvidedFilePath, errors)
    }

    private fun analyze(def: Def, symbolTable: SymbolTable): List<SemanticError> {
        val typeError: SemanticError? = when (def) {
            is Def.ValueDef.SimpleValueDef -> {
                if (def.declaredType != null) {
                    val context = TypeErrorContext.VariableDefinition(def.id)

                    val declaredType = symbolTable.findType(def.declaredType)
                    if (declaredType == null) {
                        SemanticError.TypeNotFound(context, def.declaredType)
                    } else {
                        val actualType = BuiltInTypes.Int
                        if (declaredType != actualType) {
                            SemanticError.TypeMismatch(context, declaredType, actualType)
                        } else {
                            null
                        }
                    }
                } else {
                    null
                }
            }
        }
        return if (typeError == null)
            emptyList()
        else
            listOf(typeError)
    }
}
