package io.github.ajoz.k4ap.javainterop.misc

object FunctionsKotlin {
    fun acceptAFunction(s: String, func: (String) -> Int) {
        println("Length of string: $s is ${func(s)}")
    }

    // Ways we can return a function (String) -> Int
    //we do an explicit return type and explicit type in lambda
    fun returnAFunction(): (String) -> Int {
        return { s: String -> s.length }
    }

    //we do an explicit return type and inferred type in lambda
    fun returnAFunction2(): (String) -> Int {
        return { s -> s.length }
    }

    //we do an explicit return type and single line expression
    fun returnAFunction3(): (String) -> Int = { s: String -> s.length }

    //we do an explicit return type and a single line inferred expression
    fun returnAFunction4(): (String) -> Int = { s -> s.length }

    //we do an explicit return type and a single line function declaration
    fun returnAFunction5(): (String) -> Int = fun(s: String): Int { return s.length }

    //we do an explicit return type and return function declaration
    fun returnAFunction6(): (String) -> Int {
        return fun(s: String): Int {
            return s.length
        }
    }

    //we do an inferred return type and a lambda
    fun returnAFunction7() = { s: String -> s.length }

    //we do an inferred return type and a function declaration
    fun returnAFunction8() = fun(s: String): Int { return s.length }

    // we return a reference to a method
    fun returnAFunction9() = String::length
}