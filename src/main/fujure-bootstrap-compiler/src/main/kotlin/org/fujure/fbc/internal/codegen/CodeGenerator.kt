package org.fujure.fbc.internal.codegen

import org.fujure.fbc.CompileOptions
import org.fujure.fbc.internal.CodeGenResult
import org.fujure.fbc.parse.ParsingResult

interface CodeGenerator {
    fun generate(compileOptions: CompileOptions,
                 parsingSucceeded: ParsingResult.ParsingSucceeded): CodeGenResult
}
