package org.fujure.fbc.internal.codegen

import org.fujure.fbc.CompileOptions
import org.fujure.fbc.internal.CodeGenResult
import org.fujure.fbc.internal.ReadFile
import org.fujure.fbc.internal.CodeGenerator as CodeGen
import org.fujure.fbc.parse.ParsingResult

object JavaPoetCodeGenarator : CodeGenerator  {
    override fun generate(compileOptions: CompileOptions,
                          parsingSucceeded: ParsingResult.ParsingSucceeded): CodeGenResult {
        return CodeGen(listOf(ReadFile.ParsedFile(parsingSucceeded.userProvidedFilePath,
                parsingSucceeded.ast)), compileOptions.outputDir).generate()[0]
    }
}
