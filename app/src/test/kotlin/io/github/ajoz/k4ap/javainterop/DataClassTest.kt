package io.github.ajoz.k4ap.javainterop

import io.github.ajoz.k4ap.javainterop.misc.PersonKotlin
import org.junit.Test

@Suppress("IllegalIdentifier")
class DataClassTest {
    @Test
    fun `Should allow destructuring of a data class`() {
        val personKotlin = PersonKotlin("Kotlin4", "AndroidProgrammers", 25)
        val (name, surname) = personKotlin
        println(name)
        println(surname)
    }

    @Test
    fun `Should allow to create a copy`() {
        val personKotlin = PersonKotlin("Kotlin4", "AndroidProgrammers", 25)
        val personCopy = personKotlin.copy("JUG Lodz")
        println(personKotlin)
        println(personCopy)
    }

    @Test
    fun `Should use a named argument`() {
        val personKotlin = PersonKotlin("Kotlin4", "AndroidProgrammers", 25)
        val personCopy = personKotlin.copy(surname = "", name = "Copy", age = 1)
        println(personKotlin)
        println(personCopy)
    }
}