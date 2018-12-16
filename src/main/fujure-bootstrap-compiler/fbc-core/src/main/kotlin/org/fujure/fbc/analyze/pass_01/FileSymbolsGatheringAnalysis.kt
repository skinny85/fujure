package org.fujure.fbc.analyze.pass_01

import org.fujure.fbc.analyze.SemanticError
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.FileSymbolTable
import org.fujure.fbc.common.NameValidator
import org.fujure.fbc.parse.ParsedFile

object FileSymbolsGatheringAnalysis {
    fun analyze(parsedFile: ParsedFile): Pair<FileSymbolTable, List<SemanticError>> {
        val fileSymbolTableBuilder = FileSymbolTableBuilder(parsedFile.inputFile, parsedFile.ast.packageName)
        val errors = mutableListOf<SemanticError>()

        for (def in parsedFile.ast.defs) {
            when (def) {
                is Def.ValueDef.SimpleValueDef -> {
                    val id = def.id
                    if (!NameValidator.validValueName(id))
                        errors.add(SemanticError.InvalidName(id))
                    if (!fileSymbolTableBuilder.noteSimpleValueDeclaration(id, def.declaredType, def.initializer))
                        errors.add(SemanticError.DuplicateDefinition(id))
                }
            }
        }

        return Pair(fileSymbolTableBuilder.build(), errors)
    }
}
