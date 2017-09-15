package org.fujure.fbc.analyze.pass_01

import org.fujure.fbc.analyze.SemanticError
import org.fujure.fbc.ast.AstRoot
import org.fujure.fbc.ast.FileContents
import org.fujure.fbc.parse.ParsedFile
import org.funktionale.either.Either

object FileSymbolsGatheringAnalysis {
    fun analyze(parsedFile: ParsedFile): FileSymbolsGatheringResult {
        val packageName = parsedFile.parseTree.accept(PackageNameExtractor, Unit)
        val fileSymbolTableBuilder = FileSymbolTableBuilder(parsedFile.userProvidedFilePath)

        val eitherFailureOrListOfDefs = parsedFile.parseTree.accept(DefsGatherVisitor, fileSymbolTableBuilder)
        return when (eitherFailureOrListOfDefs) {
            is Either.Left -> eitherFailureOrListOfDefs.l
            is Either.Right -> FileSymbolsGatheringResult.Success(
                    AstRoot(parsedFile.userProvidedFilePath,
                            FileContents(packageName, eitherFailureOrListOfDefs.r)),
                    fileSymbolTableBuilder.build())
        }
    }
}

sealed class FileSymbolsGatheringResult {
    data class Failure(val errors: List<SemanticError>) :
            FileSymbolsGatheringResult()

    data class Success(val astRoot: AstRoot, val fileSymbolTable: FileSymbolTable) :
            FileSymbolsGatheringResult()
}
