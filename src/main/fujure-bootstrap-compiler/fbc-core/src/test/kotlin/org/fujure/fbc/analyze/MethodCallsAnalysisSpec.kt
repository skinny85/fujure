package org.fujure.fbc.analyze

import org.assertj.core.api.Assertions.assertThat

class MethodCallsAnalysisSpec : AbstractSemanticAnalysisSpec() { init {
    describes("Method calls Semantic Analysis") {
        it.describes("for a call to an int literal method from the Int module") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def a: Int = (-1).abs()
                        """)
                        .analyzed()
            }

            it.should("be analyzed correctly") {
                assertAnalysisSucceeded()
            }
        }

        it.describes("for a local module function called as a method on an int literal") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def abs(i: Int): String = "abs"
                            def a: String = (-1).abs()
                        """)
                        .analyzed()
            }

            it.should("be analyzed correctly") {
                assertAnalysisSucceeded()
            }
        }
    }
}}
