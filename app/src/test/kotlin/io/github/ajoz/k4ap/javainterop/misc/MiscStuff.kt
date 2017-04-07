package io.github.ajoz.k4ap.javainterop.misc

import io.github.ajoz.k4ap.kotlininterop.misc.PersonJava

data class Item @JvmOverloads constructor(val name: String, val value: Int = 0)

fun nullSafety() {
    var a: String = "Kotlin4AndroidProgrammers"
    // a = null  - Won't compile
    var b: String? = "JUG Lodz"
    b = null // ok

    // chaining potentially null calls
    val length: Int? = b?.length

    // invoking only for non null
    length?.let(::println)

    // elvis operator for default value if null
    val getOrElse = length ?: 0

    // if your not afraid of NPE
    val oops = length!!
}

fun smartCasts() {
    val obj = "Kotlin4AndroidProgrammers"
    if (obj is String) {
        print(obj.length) // no need for a cast
    }

    if (obj !is String) { // same as !(obj is String)
        print("Not a String")
    } else {
        print(obj.length)
    }

    if (obj !is String || obj.length == 0) return
}

fun PersonKotlin.swap() = PersonKotlin(surname, name, age)
fun PersonKotlin.toJava() = PersonJava(name, surname, age)
fun PersonJava.swap() = PersonJava(surname, name, age)
fun PersonJava.toKotlin() = PersonKotlin(name, surname, age)
