package io.github.ajoz.k4ap.javainterop

import io.github.ajoz.k4ap.javainterop.misc.toKotlin
import io.github.ajoz.k4ap.kotlininterop.misc.CollectionsJava
import io.github.ajoz.k4ap.kotlininterop.misc.FunctionsJava
import io.github.ajoz.k4ap.kotlininterop.misc.FunctionsJava.FunctionJava
import io.github.ajoz.k4ap.kotlininterop.misc.PersonJava
import org.junit.Test

@Suppress("IllegalIdentifier")
class JavaInteropTest {
    @Test
    fun `Should be able to call Java Person class`() {
        val personJava = PersonJava("Kotlin4", "AndroidDevelopers", 25)
        println(personJava.name)
        println(personJava.surname)
        println(personJava.age)
        println(personJava)
    }

    @Test
    fun `Should be able to print a Java collection`() {
        val smallListOfInts = CollectionsJava.getSmallListOfInts()
        println(smallListOfInts)
    }

    @Test
    fun `Should be able to process the Java collection`() {
        val persons = CollectionsJava.getListOfPersons()

        // separation of concerns (non lazy)
        val filtered = persons
                .filter { it.age > 7 } /*Filtering*/
                .map { it.name.toUpperCase() } /*Mapping*/
                .sorted() /*Sorting*/
                .take(3) /*Taking 3 or less*/

        println(filtered)
    }

    @Test
    fun `Should be able to lazy process the Java collection`() {
        val persons = CollectionsJava.getListOfPersons()

        val filtered = persons.asSequence()
                .onEach { println("Before Filtering: $it") }
                .filter { it.age > 7 } /*Filtering*/
                .onEach { println("After Filtering: $it") }
                .map { it.name.toUpperCase() } /*Mapping*/
                .onEach { println("Mapping: $it") }
                .sorted() /*Sorting*/
                .onEach { println("Sorting: $it") }
                .take(n = 3) /*Taking 3 or less*/

        // Sequence means lazy processing onEach would show us something if
        // this would be an eager operation
        println(filtered.toList())
    }

    @Test
    fun `Java method should accept a function`() {
        //long and tedious
        FunctionsJava.acceptAFunction("Kotlin4AndroidProgrammers", object : FunctionJava<String, Int> {
            override fun apply(value: String): Int {
                return value.length
            }
        })

        //shorter and better
        FunctionsJava.acceptAFunction("JUG Lodz", String::length)
    }

    @Test
    fun `Java method should return a function`() {
        val func = FunctionsJava.returnAFunction()
        println(func.apply("Kotlin4AndroidProgrammers"))
    }

    @Test
    fun `Kotlin extension on a Java class`() {
        val personJava = PersonJava("Kotlin4", "AndroidDevelopers", 25)
        val personKotlin = personJava.toKotlin()
        println(personKotlin)
    }
}