package org.fujure.truffle

import org.assertj.core.api.Assertions.assertThat
import org.graalvm.polyglot.Context

class ReferencesAndImportsTruffleSpec : AbstractTruffleSpec() { init {
    describes("Fujure Truffle implementation with files referencing and importing") {
        it.beginsAll {
            context = Context.create()
        }

        it.describes("evaluating an unnamed module") {
            it.beginsAll {
                evalFujure("""
                    package com.example

                    def a = 3
                """)
            }

            it.should("correctly save its bindings") {
                assertNoException()
                assertThat(fujureBindings.hasMember("com.example.Unnamed")).isTrue()
            }

            it.describes("and then a module in a different package that imports it") {
                it.beginsAll {
                    evalFujure("""
                        package com.example.inner

                        import com.example.Unnamed

                        def b = Unnamed.a
                    """)
                }

                it.should("correctly evaluate the importing module") {
                    assertNoException()
                    assertThat(fujureBindings.hasMember("com.example.inner.Unnamed")).isTrue()
                    val importingModuleBindings = fujureBindings.getMember("com.example.inner.Unnamed")
                    assertThat(importingModuleBindings.getMember("b").asInt()).isEqualTo(3)
                }
            }

            it.describes("and then a named module in the same package referencing it") {
                it.beginsAll {
                    evalFujure("""
                        package com.example

                        def b = Unnamed.a
                    """,
                    "File1.fjr")
                }

                it.should("correctly evaluate the referencing module") {
                    assertNoException()
                    assertThat(fujureBindings.hasMember("com.example.File1")).isTrue()
                    val referencingModuleBindings = fujureBindings.getMember("com.example.File1")
                    assertThat(referencingModuleBindings.getMember("b").asInt()).isEqualTo(3)
                }
            }
        }
    }
}}
