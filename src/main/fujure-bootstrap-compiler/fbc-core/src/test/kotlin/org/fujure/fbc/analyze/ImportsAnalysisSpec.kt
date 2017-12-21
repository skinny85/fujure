package org.fujure.fbc.analyze;

import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.ast.Import

class ImportsAnalysisSpec : AbstractSemanticAnalysisSpec() {
    init {
        describes("Imports Semantic Analysis") {
            it.describes("when a module references a value from another module in a different package with an import") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                package com.example

                                def a: Int = 42
                            """)
                            .file("""
                                package com.example.inner

                                import com.example.File1

                                def x: Int = File1.a
                            """)
                            .analyzed()
                }

                it.should("succeed") {
                    assertAnalysisSucceeded()
                }
            }

            it.describes("when a module imports another module from the default package") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a = 1
                            """)
                            .file("""
                                package inner

                                import File1

                                def x = File1.a
                            """)
                            .analyzed()
                }

                it.should("fail") {
                    assertAnalysisFailed()
                }

                it.should("analyze the imported file correctly") {
                    assertFile1IsCorrect()
                }

                it.should("report an UnresolvedImport error for the importing file") {
                    assertThat(file2Errors()).contains(
                            SemanticError.UnresolvedImport(Import("File1")))
                }
            }

            it.describes("when a module imports itself") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                package com.example

                                import com.example.File1
                            """)
                            .analyzed()
                }

                it.should("succeed") {
                    assertAnalysisSucceeded()
                }
            }
        }
    }
}
