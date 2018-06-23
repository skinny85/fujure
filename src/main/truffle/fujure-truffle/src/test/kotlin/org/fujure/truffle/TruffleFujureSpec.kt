package org.fujure.truffle

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.fujure.truffle.FujureTruffleLanguage.Companion.LANG_ID
import org.graalvm.polyglot.Context
import org.graalvm.polyglot.PolyglotException
import org.specnaz.kotlin.junit.SpecnazKotlinJUnit

class TruffleFujureSpec : SpecnazKotlinJUnit("Fujure on Truffle", {
    lateinit var context: Context

    it.beginsEach {
        context = Context.create()
    }

    it.should("evaluate code in the default package to 42") {
        val value = context.eval(LANG_ID, "def a = 1")

        assertThat(value.asInt()).isEqualTo(42)

        assertThat(context.getBindings(LANG_ID).hasArrayElements()).isFalse()

        assertThat(context.getBindings(LANG_ID).hasMembers()).isTrue()
        assertThat(context.getBindings(LANG_ID).memberKeys).containsOnly("Unnamed")
        assertThat(context.getBindings(LANG_ID).hasMember("Unnamed")).isTrue()
        assertThatThrownBy {
            context.getBindings(LANG_ID).putMember("x", 3)
        }.isInstanceOf(UnsupportedOperationException::class.java)

        val fileBindings = context.getBindings(LANG_ID).getMember("Unnamed")
        assertThat(fileBindings).isNotNull()
        assertThat(fileBindings.hasMembers()).isTrue()
        assertThat(fileBindings.memberKeys).containsOnly("a")
        assertThat(fileBindings.hasMember("a")).isTrue()

        assertThat(fileBindings.hasMember("x")).isFalse()
        assertThat(fileBindings.getMember("x")).isNull()
    }

    it.should("evaluate code in a non-default package to 129") {
        val value = context.eval(LANG_ID, """
                package com.example

                def b = 2
            """)

        assertThat(value.asInt()).isEqualTo(129)

        assertThat(context.getBindings(LANG_ID).hasArrayElements()).isFalse()

        assertThat(context.getBindings(LANG_ID).hasMembers()).isTrue()
        assertThat(context.getBindings(LANG_ID).memberKeys).containsOnly("com.example.Unnamed")
        assertThat(context.getBindings(LANG_ID).hasMember("com.example.Unnamed")).isTrue()

        val fileBindings = context.getBindings(LANG_ID).getMember("com.example.Unnamed")
        assertThat(fileBindings).isNotNull()
        assertThat(fileBindings.hasMembers()).isTrue()
        assertThat(fileBindings.memberKeys).containsOnly("b")
        assertThat(fileBindings.hasMember("b")).isTrue()

        val b = fileBindings.getMember("b")
        assertThat(b).isNotNull()
        assertThat(b.isNumber).isFalse()
        assertThat(b.canExecute()).isFalse()
    }

    it.shouldThrow<PolyglotException>("when evaluating syntactically incorrect code") {
        context.eval(LANG_ID, "1 + 2")
    }.withoutCause()
})
