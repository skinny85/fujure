package org.fujure.fbc.analyze;

import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.ast.Import
import org.fujure.fbc.ast.ValueReference

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

            it.describes("called with a file importing a non-existent module") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                import com.example.File2
                            """)
                            .analyzed()
                }

                it.should("report an UnresolvedImport error") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.UnresolvedImport(
                                    Import("com", "example", "File2")))
                }
            }

            it.describes("called with an import shadowing a module in the same package") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                package com.example

                                def x = 3
                            """)
                            .named("File1")
                            .file("""
                                package com.example.inner

                                def x = true
                            """)
                            .named("inner/File1")
                            .file("""
                                package com.example

                                import com.example.inner.File1

                                def a: Bool = File1.x
                            """)
                            .named("File2.fjr")
                            .analyzed()
                }

                it.should("succeed") {
                    assertAnalysisSucceeded()
                }
            }

            it.describes("called with an import shadowing a module in the same package that contains a value missing in the imported module") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                package com.example

                                def x = false
                            """)
                            .named("File1")
                            .file("""
                                package com.example.inner

                                def y = 42
                            """)
                            .named("inner/File1")
                            .file("""
                                package com.example

                                import com.example.inner.File1

                                def a: Bool = File1.x
                            """)
                            .named("File2.fjr")
                            .analyzed()
                }

                it.should("correctly report an UnresolvedReference error") {
                    assertThat(fileErrors("File2.fjr")).containsExactly(
                            SemanticError.UnresolvedReference(
                                    ErrorContext.ValueDefinition("a"),
                                    ValueReference("File1", "x")))
                }
            }
        }
    }
}
