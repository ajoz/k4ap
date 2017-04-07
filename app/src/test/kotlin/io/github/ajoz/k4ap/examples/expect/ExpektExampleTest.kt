package io.github.ajoz.k4ap.examples.expect

import com.winterbe.expekt.should
import org.junit.Test

/**
 * Expekt is a (work in progress) BDD assertion library for Kotlin, inspired by Chai.js. It works with your favorite
 * test runner such as JUnit and Spek.
 * https://github.com/winterbe/expekt
 */
class ExpektExampleTest {
    @Test
    fun shouldReturnCorrectStringLength() {
        //given:
        val string = "Kotlin4AndroidProgrammers"
        //when:
        val length = string.map {
            c ->
            if (c.isLowerCase()) {
                c.toUpperCase()
            } else {
                c.toLowerCase()
            }
        }.size
        //then:
        length.should.equal(25)
    }

    @Test
    fun shouldConsistOfCorrectSubstring() {
        //given:
        val string = "Kotlin4AndroidProgrammers"
        //then:
        string.should.not.contain("JUG Lodz")
    }

    @Test
    fun mappedListShouldHaveCorrectSize() {
        //given:
        val string = "Kotlin4AndroidProgrammers"
        //when:
        val filtered = string
                .map(Char::isLowerCase)
                .filter { it }
        //then:
        filtered.should.have.size.above(10)
    }
}