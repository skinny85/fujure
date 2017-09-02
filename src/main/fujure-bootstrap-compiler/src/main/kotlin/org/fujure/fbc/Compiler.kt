package org.fujure.fbc

interface Compiler {
    fun compile(compileOptions: CompileOptions, files: List<String>): CompilationResults
}

data class CompileOptions(val outputDir: String = ".")
