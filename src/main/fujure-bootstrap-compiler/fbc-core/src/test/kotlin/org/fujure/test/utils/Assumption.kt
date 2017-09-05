package org.fujure.test.utils

import kotlin.reflect.full.cast
import kotlin.reflect.full.isSubclassOf

class Assumption private constructor(val subject: Any) {
    inline fun <reified T : Any> isA(): T = isAn<T>()

    inline fun <reified T : Any> isAn(): T =
            if (subject::class.isSubclassOf(T::class)) {
                T::class.cast(subject)
            } else {
                throw RuntimeException("Expected $subject to be of type ${T::class}")
            }

    companion object {
        fun assume(suject: Any): Assumption {
            return Assumption(suject)
        }
    }
}
