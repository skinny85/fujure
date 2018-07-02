package org.fujure.truffle

import org.assertj.core.api.Assertions.assertThat
import org.fujure.truffle.FujureTruffleLanguage.Companion.LANG_ID
import org.graalvm.polyglot.Context
import org.graalvm.polyglot.PolyglotException
import org.graalvm.polyglot.Value
import org.specnaz.kotlin.junit.SpecnazKotlinJUnit

class SimpleSingleFujureSourceTruffleSpecs : SpecnazKotlinJUnit("Fujure Truffle implementation", {
    lateinit var context: Context
    lateinit var result: Value
    lateinit var fujureBindings: Value

    fun evalFujure(moduleContents: String) {
        try {
            result = context.eval(LANG_ID, moduleContents)
        } finally {
            fujureBindings = context.getBindings(LANG_ID)
        }
    }

    it.beginsAll {
        context = Context.create()
    }

    it.describes("when evaluating code 'def a = 1'") {
        it.beginsAll {
            evalFujure("""
                    def a = 1
                """)
        }

        it.should("result in the value 42") {
            assertThat(result.isNumber).isTrue()
            assertThat(result.asInt()).isEqualTo(42)
        }

        it.describes("the Fujure bindings after evaluation") {
            it.should("not have Array elements") {
                assertThat(fujureBindings.hasArrayElements()).isFalse()
            }

            it.should("have members, containing only 'Unnamed'") {
                assertThat(fujureBindings.hasMembers()).isTrue()
                assertThat(fujureBindings.memberKeys).containsOnly("Unnamed")
                assertThat(fujureBindings.hasMember("Unnamed")).isTrue()
            }

            it.shouldThrow<UnsupportedOperationException>("when trying to 'put' members into them") {
                fujureBindings.putMember("x", 3)
            }

            it.shouldThrow<UnsupportedOperationException>("when trying to 'remove' members from them") {
                fujureBindings.removeMember("Unnamed")
            }

            it.describes("and the 'Unnamed' module bindings from the Fujure bindings") {
                lateinit var moduleBindings: Value

                it.beginsAll {
                    moduleBindings = fujureBindings.getMember("Unnamed")
                }

                it.should("not be null") {
                    assertThat(moduleBindings).isNotNull()
                }

                it.should("have members, containing only 'a'") {
                    assertThat(moduleBindings.hasMembers()).isTrue()
                    assertThat(moduleBindings.memberKeys).containsOnly("a")
                    assertThat(moduleBindings.hasMember("a")).isTrue()
                }

                it.shouldThrow<UnsupportedOperationException>("when trying to 'put' members into them") {
                    moduleBindings.putMember("x", 3)
                }

                it.shouldThrow<UnsupportedOperationException>("when trying to 'remove' the 'a' member from them") {
                    moduleBindings.removeMember("a")
                }

                it.should("not have member 'x'") {
                    assertThat(moduleBindings.hasMember("x")).isFalse()
                    assertThat(moduleBindings.getMember("x")).isNull()
                }

                it.describes("its 'a' member") {
                    lateinit var a: Value

                    it.beginsAll {
                        a = moduleBindings.getMember("a")
                    }

                    it.should("not be null") {
                        assertThat(a).isNotNull()
                    }

                    it.should("not be executable") {
                        assertThat(a.canExecute()).isFalse()
                    }

                    it.should("not be the Null value") {
                        assertThat(a.isNull).isFalse()
                    }

                    it.should("be equal to 1") {
                        assertThat(a.isNumber).isTrue()
                        assertThat(a.asInt()).isEqualTo(1)
                    }
                }
            }
        }
    }

    it.describes("when evaluating code with defs b & c in the com-example package") {
        it.beginsAll {
            evalFujure("""
                package com.example

                def b = "fianceę"
                def c = '\n'
            """)
        }

        it.should("result in the value 129") {
            assertThat(result.asInt()).isEqualTo(129)
        }

        it.describes("the Fujure bindings after evaluation") {
            it.should("not have Array elements") {
                assertThat(fujureBindings.hasArrayElements()).isFalse()
            }

            it.should("have members, containing only 'com.example.Unnamed'") {
                assertThat(fujureBindings.hasMembers()).isTrue()
                assertThat(fujureBindings.memberKeys).containsOnly("com.example.Unnamed")
                assertThat(fujureBindings.hasMember("com.example.Unnamed")).isTrue()
            }

            it.describes("and the 'com.example.Unnamed' module bindings from the Fujure bindings") {
                lateinit var moduleBindings: Value

                it.beginsAll {
                    moduleBindings = fujureBindings.getMember("com.example.Unnamed")
                }


                it.should("not be null") {
                    assertThat(moduleBindings).isNotNull()
                }

                it.should("have members, containing only 'b' and 'c'") {
                    assertThat(moduleBindings.hasMembers()).isTrue()
                    assertThat(moduleBindings.memberKeys).containsOnly("b", "c")
                    assertThat(moduleBindings.hasMember("b")).isTrue()
                    assertThat(moduleBindings.hasMember("c")).isTrue()
                }

                it.describes("its 'b' member") {
                    lateinit var b: Value

                    it.beginsAll {
                        b = moduleBindings.getMember("b")
                    }

                    it.should("be equal to the given String literal, including Unicode characters") {
                        assertThat(b.asString()).isEqualTo("fianceę")
                    }
                }

                it.describes("its 'c' member") {
                    lateinit var c: Value

                    it.beginsAll {
                        c = moduleBindings.getMember("c")
                    }

                    it.should("be equal to the given char literal, including escaped characters") {
                        assertThat(c.asInt()).isEqualTo('\n'.toInt())
                    }
                }
            }
        }
    }

    it.describes("when evaluating syntactically incorrect code") {
        it.shouldThrow<PolyglotException>("that is a non-internal syntax error") {
            evalFujure("1 + 2")
        }.withoutCause().satisfying { e ->
            assertThat(e.isGuestException).isTrue()
            assertThat(e.isInternalError).isFalse()
            assertThat(e.isSyntaxError).isTrue()
        }

        it.should("not add the incorrect module bindings to Fujure's bindings") {
            assertThat(fujureBindings.memberKeys).isEmpty()
        }
    }

    it.describes("when evaluating a def referring to a previous def in the same module") {
        lateinit var moduleBindings: Value

        it.beginsAll {
            evalFujure("""
                def a = 13
                def b = a
            """)

            moduleBindings = fujureBindings.getMember("Unnamed")
        }

        it.should("result in the same value as that previous def") {
            assertThat(moduleBindings.memberKeys).containsOnly("a", "b")
            val a = moduleBindings.getMember("a")
            assertThat(a.asInt()).isEqualTo(13)
            val b = moduleBindings.getMember("b")
            assertThat(b.asInt()).isEqualTo(13)
        }
    }

    it.describes("when evaluating code referring to a non-existent value") {
        it.shouldThrow<PolyglotException>("that is not an internal nor syntax error") {
            evalFujure("""
                def a = x
            """)
        }.withoutCause().satisfying { e ->
            assertThat(e.isGuestException).isTrue()
            assertThat(e.isInternalError).isFalse()
            assertThat(e.isSyntaxError).isFalse()

            assertThat(e.message)
                    .contains("'x'")
                    .containsIgnoringCase("unresolved")
                    .containsIgnoringCase("reference")
        }
    }
})
