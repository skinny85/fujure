package org.fujure.fbc.analyze

class StatementsAnalysisSpec : AbstractSemanticAnalysisSpec() { init {
    describes("Statements Semantic Analysis") {
        it.describes("for a block with one statement") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def main(): IO<Unit> = {
                                IO.putStrLn("Hello, world!");
                            }
                        """)
                        .analyzed()
            }

            it.should("be analyzed correctly") {
                assertAnalysisSucceeded()
            }
        }
    }
}}
