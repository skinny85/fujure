package org.fujure.truffle

import org.assertj.core.api.Assertions.assertThat
import org.fujure.truffle.runtime.IO
import org.fujure.truffle.runtime.io.Effect
import org.graalvm.polyglot.Context
import org.graalvm.polyglot.Value

class SingleFileFujureTruffleSpec : AbstractTruffleSpec() { init {
    describes("Fujure Truffle implementation for a single file") {
        it.beginsAll {
            context = Context.create()
        }

        it.describes("when evaluating code 'def a = 1'") {
            it.beginsAll {
                evalFujure("""
                    def a = 1
                """)
            }

            it.should("result in a value for which isNull returns true") {
                assertNoException()
                assertThat(result.isNull).isTrue()
            }

            it.describes("the Fujure bindings after evaluation") {
                it.should("not have Array elements") {
                    assertThat(fujureBindings.hasArrayElements()).isFalse()
                }

                it.should("have user-defined members, containing only 'Unnamed'") {
                    assertThat(fujureBindings.userDefinedMemberKeys()).containsOnly("Unnamed")
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

            it.should("result in a value for which isNull returns true") {
                assertNoException()
                assertThat(result.isNull).isTrue()
            }

            it.describes("the Fujure bindings after evaluation") {
                it.should("not have Array elements") {
                    assertThat(fujureBindings.hasArrayElements()).isFalse()
                }

                it.should("have user-defined members, containing only 'com.example.Unnamed'") {
                    assertThat(fujureBindings.userDefinedMemberKeys()).containsOnly("com.example.Unnamed")
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

        it.describes("when evaluating code with Boolean and Unit literals") {
            it.beginsAll {
                evalFujure("""
                    def u = unit
                    def b: Bool = true
                """)
            }

            lateinit var moduleBindings: Value

            it.beginsAll {
                assertNoException()
                moduleBindings = fujureBindings.getMember("Unnamed")
            }

            it.should("evaluate the unit value to the Unit instance") {
                val u = moduleBindings.getMember("u")
                assertThat(u).isNotNull()
            }

            it.should("evaluate the Boolean value to the correct Boolean literal") {
                val b = moduleBindings.getMember("b")
                assertThat(b.asBoolean()).isEqualTo(true)
            }
        }

        it.describes("when evaluating code with expressions") {
            it.beginsAll {
                evalFujure("""
                    def b: Bool = ! true
                    def b2 = !false || b && false
                    def b3 = 2 >= 1 && 3 <= 1
                    def intMax = 2147483647
                    def i = 3 + (intMax - (intMax - 2))
                    def b4 = !("a" == "b") != true
                    def b5 = "b" + "5"
                    def b6 = let
                        a1 = 3,
                        b6 = let a = "flse" in a
                    in
                        !(a1 + 1 != 4)
                    def i2 = if b6 then 23 else 45
                    def minusOne: Int = Int.minInt + Int.maxInt
                    def three = +Int.abs(-3)
                """)
            }

            lateinit var moduleBindings: Value

            it.beginsAll {
                assertNoException()
                moduleBindings = fujureBindings.getMember("Unnamed")
                assertThat(moduleBindings).isNotNull()
            }

            it.should("correctly evaluate the complement expression") {
                val b = moduleBindings.getMember("b")
                assertThat(b.asBoolean()).isFalse()
            }

            it.should("correctly evaluate the complex Boolean expression") {
                val b2 = moduleBindings.getMember("b2")
                assertThat(b2.asBoolean()).isTrue()
            }

            it.should("correctly evaluate the number ordering expression") {
                val b3 = moduleBindings.getMember("b3")
                assertThat(b3.asBoolean()).isFalse()
            }

            it.should("correctly evaluate the integer arithmetic expression") {
                val i = moduleBindings.getMember("i")
                assertThat(i.asInt()).isEqualTo(5)
            }

            it.should("correctly evaluate the comparison expression") {
                val b4 = moduleBindings.getMember("b4")
                assertThat(b4.asBoolean()).isFalse()
            }

            it.should("correctly evaluate the String concatenation expression") {
                val b5 = moduleBindings.getMember("b5")
                assertThat(b5.asString()).isEqualTo("b5")
            }

            it.should("correctly evaluate the 'let' expression") {
                val b6 = moduleBindings.getMember("b6")
                assertThat(b6.asBoolean()).isTrue()
            }

            it.should("correctly evaluate the 'if' expression") {
                val i2 = moduleBindings.getMember("i2")
                assertThat(i2.asInt()).isEqualTo(23)
            }

            it.should("correctly evaluate the Int.minInt + Int.maxInt expression") {
                val minusOne = moduleBindings.getMember("minusOne")
                assertThat(minusOne.asInt()).isEqualTo(-1)
            }

            it.should("correctly evaluate the Int.abs(3) expression") {
                val three = moduleBindings.getMember("three")
                assertThat(three.asInt()).isEqualTo(3)
            }

            it.describes("when retrieving a built-in function value") {
                lateinit var intModuleBindings: Value
                lateinit var intAbsFunction: Value

                it.beginsAll {
                    intModuleBindings = fujureBindings.getMember("fujure.Int")
                    intAbsFunction = intModuleBindings.getMember("abs")
                }

                it.should("be callable") {
                    assertThat(intAbsFunction.canExecute()).isTrue()
                }

                it.should("return the correct value when called") {
                    val ret = intAbsFunction.execute(-3)
                    assertThat(ret.asInt()).isEqualTo(3)
                }
            }
        }

        it.describes("when evaluating code with function definitions") {
            it.beginsAll {
                evalFujure("""
                    def inc(n: Int): Int = n + i
                    
                    def i = inc(1)
                    
                    def inc_indirect(): Int -> Int = inc
                    
                    def main(): Int = inc_indirect()(33)
                """)
            }

            it.should("evaluate to the result of 'main'") {
                assertNoException()

                assertThat(result.asInt()).isEqualTo(34)
            }
        }

        it.describes("when evaluating code with method calls") {
            it.beginsAll {
                evalFujure("""
                   def result1 = (-1).abs() 
                   def result2 = (-3).min(2) + -5.max(4)
                """)
            }

            it.should("evaluate without errors") {
                assertNoException()
            }

            it.should("return 1 for (-1).abs()") {
                val result = fujureBindings.getMember("Unnamed").getMember("result1")

                assertThat(result.asInt()).isEqualTo(1)
            }

            it.should("return -8 for (-3).min(2) + -5.max(4)") {
                val result = fujureBindings.getMember("Unnamed").getMember("result2")

                assertThat(result.asInt()).isEqualTo(-8)
            }
        }

        it.describes("when evaluating IO methods") {
            it.beginsAll {
                evalFujure("""
                    import fujure.io.std.IO

                    def main(): IO<Unit> = IO.putStrLn("Tic")
                        .chain(IO.putStrLn("Tac"))
                        .chain(IO.putStrLn("Toe"))
                """)
            }

            it.should("evaluate without errors") {
                assertNoException()
            }

            it.should("return an IO result") {
                val io = result.asHostObject<IO<*>>()
                assertThat(io.effects).containsExactly(
                        Effect.Print("Tic\n"),
                        Effect.Print("Tac\n"),
                        Effect.Print("Toe\n")
                )
            }
        }

        it.describes("when evaluating code with statement blocks") {
            it.beginsAll {
                evalFujure("""
                    import fujure.io.std.IO

                    def main(): IO<Unit> = {
                        IO.putStrLn("Bep");
                        IO.putStrLn("Bop");
                    }
                """)
            }

            it.should("evaluate without errors") {
                assertNoException()
            }

            it.should("return an IO result with all statements chained") {
                val io = result.asHostObject<IO<*>>()
                assertThat(io.effects).containsExactly(
                        Effect.Print("Bep\n"),
                        Effect.Print("Bop\n"))
            }
        }

        it.describes("when evaluating syntactically incorrect code") {
            it.beginsAll {
                evalFujure("1 + 2")
            }

            it.should("throw a guest PolyglotException that is a non-internal syntax error") {
                assertThatPolyglot().isGuestSyntaxError()
            }

            it.should("not add the incorrect module's bindings to Fujure's user-defined bindings") {
                assertThat(fujureBindings.userDefinedMemberKeys()).isEmpty()
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
            it.beginsAll {
                evalFujure("""
                    def a = x
                    def b = a
                    def c = b
                """)
            }

            it.should("throw a guest PolyglotException that is not an internal nor syntax error") {
                assertThatPolyglot()
                        .isGuestNonSyntaxError()
                        .message()
                        .contains("'x'")
                        .contains("a:")
                        .containsIgnoringCase("unresolved")
                        .containsIgnoringCase("reference")
                        .doesNotContain("'a'")
                        .doesNotContain("'b'")
                        .doesNotContain("b:")
                        .doesNotContain("c:")
            }

            it.should("not add the incorrect module's bindings to Fujure's user-defined bindings") {
                assertThat(fujureBindings.userDefinedMemberKeys()).isEmpty()
            }
        }

        it.describes("when assigning a String to an Int-typed value") {
            it.beginsAll {
                evalFujure("""
                    def a: Int = "1"
                """)
            }

            it.should("throw a guest PolyglotException that is not an internal nor syntax error") {
                assertThatPolyglot()
                        .isGuestNonSyntaxError()
                        .hasMessageContaining("a:")
                        .hasMessageContaining("Int")
                        .hasMessageContaining("String")
            }

            it.should("not add the incorrect module's bindings to Fujure's user-defined bindings") {
                assertThat(fujureBindings.userDefinedMemberKeys()).isEmpty()
            }
        }

        it.describes("when declaring a definition with a non-existent declared type and an incorrect initializer") {
            it.beginsAll {
                evalFujure("""
                    def a: SomeTypeThatDoesNotExist = x
                """)
            }

            it.should("throw an error mentioning both the non-existent declared type and the unresolved reference") {
                assertThatPolyglot()
                        .isGuestNonSyntaxError()
                        .message()
                        .contains("a:")
                        .contains("SomeTypeThatDoesNotExist")
                        .contains("'x'")
            }

            it.should("not add the incorrect module's bindings to Fujure's user-defined bindings") {
                assertThat(fujureBindings.userDefinedMemberKeys()).isEmpty()
            }
        }

        it.describes("when assigning a Char to an Int variable") {
            it.beginsAll {
                evalFujure("""
                    def a: Int = 'x'
                """)
            }

            it.should("throw a guest PolyglotException that is not an internal nor syntax error") {
                assertThatPolyglot()
                        .isGuestNonSyntaxError()
                        .hasMessageContaining("a:")
                        .hasMessageContaining("Int")
                        .hasMessageContaining("Char")
            }

            it.should("not add the incorrect module's bindings to Fujure's user-defined bindings") {
                assertThat(fujureBindings.userDefinedMemberKeys()).isEmpty()
            }
        }
    }
}}
