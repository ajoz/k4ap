package io.github.ajoz.k4ap.javainterop.misc

object FunctionsKotlin {
    fun acceptAFunction(s: String, func: (String) -> Int) {
        println("Length of string: $s is ${func(s)}")
    }

    fun returnAFunction(): (String) -> Int {
        return { s: String -> s.length }
    }
}