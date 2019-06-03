package a

val i = 3

fun f(s: String): Char = 'c'

fun g(func: (String) -> Char): Double = Double.POSITIVE_INFINITY

fun main() {
//    f(i) // Type mismatch (required: String, found: Int)
//    f(i, "s") // Type mismatch (required: String, found: Int), too many arguments for function f
//    f(::f) // Type mismatch (required: String, found: KFunction1<String, Char>)
//    i(2) // expression 'i' of type 'Int' cannot be invoked as a function. The function 'invoke' cannot be found
//    undefined(i, j) // unresolved reference: undefined, unresolved reference: j
}
