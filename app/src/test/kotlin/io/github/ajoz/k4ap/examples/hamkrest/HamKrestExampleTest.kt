package io.github.ajoz.k4ap.examples.hamkrest

import com.natpryce.hamkrest.*
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.should.shouldMatch
import org.junit.Ignore
import org.junit.Test

/**
 * HamKrest - Hamcrest for Kotlin
 * A reimplementation of Hamcrest to take advantage of Kotlin language features.
 * https://github.com/npryce/hamkrest
 */
class HamKrestExampleTest {
    @Test
    fun shouldUseHamKrestForMatching() {
        //given:
        val string = "Kotlin4AndroidProgrammers"
        //then:
        assertThat(string, startsWith("K") and endsWith("s") and !containsSubstring("JUG Lodz"))
    }

    // this example project is using bleeding edge Kotlin ;) version 1.1.1
    // kotlin recently did some adjustments to its std lib (Java 9 modularization)
    // this is why reflection was moved to a kotlin-reflect lib
    @Test
    @Ignore
    fun todayIDontLikePunctuation() {
        //given:
        val string = "Kotlin4AndroidProgrammers"
        val isLongEnough = has(String::length, greaterThan(20))
        //then I can write without punctuation
        string shouldMatch isLongEnough
    }

    @Test
    fun shouldUseAnUnaryPredicateIntoAMatcher() {
        //given:
        val string = "Kotlin4AndroidProgrammers"
        val isNotBlank = Matcher(String::isNotBlank)
        //then:
        assertThat(string, isNotBlank)
    }
}