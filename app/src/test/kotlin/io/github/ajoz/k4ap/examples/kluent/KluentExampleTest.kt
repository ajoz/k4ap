package io.github.ajoz.k4ap.examples.kluent

import org.amshove.kluent.*
import org.junit.Test

/**
 * Kluent is a "Fluent Assertions" library written specifically for Kotlin. It uses the Infix-Notations and Extension
 * Functions of Kotlin to provide a fluent wrapper around the JUnit-Asserts and Mockito.
 */
class KluentExampleTest {
    @Test
    fun shouldCorrectlyAssertEquality() {
        //given:
        val string = "Kotlin4AndroidProgrammers"
        //then:
        string shouldEqual "Kotlin4AndroidProgrammers"
        string shouldNotEqual "JUG Lodz"
    }

    @Test
    fun shouldCorrectlyMockAnInterface() {
        //given:
        val mock = mock(ThisDemandsMocking::class)
        //when:
        When calling mock.foo() itReturns 25
        When calling mock.bar() itReturns "Kotlin4AndroidProgrammers"
        //then:
        mock.foo() shouldEqual 25
        mock.bar() shouldNotEqual "JUG Lodz"
    }

    // we need to suppress this lint warning because its afraid we are using
    // space in the identifier which is OK with Kotlin
    @Suppress("IllegalIdentifier")
    @Test
    fun shouldBeAbleToUseBackTicks() {
        "Kotlin4AndroidProgrammers" `should not equal` "JUG Lodz"
    }
}

interface ThisDemandsMocking {
    fun foo(): Int
    fun bar(): String
}