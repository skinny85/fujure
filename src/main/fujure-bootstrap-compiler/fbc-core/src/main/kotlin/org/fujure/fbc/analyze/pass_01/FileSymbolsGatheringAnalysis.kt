package org.fujure.fbc.analyze.pass_01

import org.fujure.fbc.analyze.SemanticError
import org.fujure.fbc.ast.AstRoot
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.FileSymbolTable
import org.fujure.fbc.common.NameValidator
import org.fujure.fbc.parse.ParsedFile

object FileSymbolsGatheringAnalysis {
    fun analyze(parsedFile: ParsedFile): FileSymbolsGatheringResult {
        val fileSymbolTableBuilder = FileSymbolTableBuilder(parsedFile.inputFile, parsedFile.ast.packageName)
        val errors = mutableListOf<SemanticError>()

        for (def in parsedFile.ast.defs) {
            when (def) {
                is Def.ValueDef.SimpleValueDef -> {
                    val id = def.id
                    if (!NameValidator.validValueName(id)) {
                        errors.add(SemanticError.InvalidName(id))
                    } else {
                        if (!fileSymbolTableBuilder.noteSimpleValueDeclaration(id, def.declaredType, def.initializer))
                            errors.add(SemanticError.DuplicateDefinition(id))
                    }
                }
            }
        }

        return if (errors.isEmpty())
            FileSymbolsGatheringResult.Success(AstRoot(parsedFile.inputFile, parsedFile.ast),
                    fileSymbolTableBuilder.build())
        else
            FileSymbolsGatheringResult.Failure(errors)
    }
}

sealed class FileSymbolsGatheringResult {
    data class Failure(val errors: List<SemanticError>) :
            FileSymbolsGatheringResult()

    data class Success(val astRoot: AstRoot, val fileSymbolTable: FileSymbolTable) :
            FileSymbolsGatheringResult()
}
