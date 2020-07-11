package org.fujure.truffle.runtime.io

import org.fujure.truffle.runtime.Unit

sealed class Effect<T> {
    abstract fun unsafePerformEffect(): T

    data class Print(private val text: String): Effect<Unit>() {
        override fun unsafePerformEffect(): Unit {
            println(text)
            return Unit.INSTANCE
        }
    }
}
