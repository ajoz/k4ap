package io.github.ajoz.k4ap.examples.vanilla

import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestName

class VanillaJUnitExampleTest {
    @Test
    fun shouldPassThisSimpleVanillaTest() {
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
        assertEquals(25, length)
    }

    // Kotlin doesn't have fields so for JUnit sake we need
    // to annotate all @Rule properties with @JvmField as a field
    // is expected
    @Rule
    @JvmField
    val testName = TestName()

    @Test
    fun shouldPassUsingJUnitRules() {
        //given:
        val expectedName = "shouldPassUsingJUnitRules"
        //when:
        val actualName = testName.methodName
        //then:
        assertEquals(expectedName, actualName)
    }
    @Test
    @Suppress("IllegalIdentifier")
    fun `This is just an example of a nice test name`() {
        //given:
        val string = "Kotlin4AndroidProgrammers"
        //then:
        assertEquals(25, string.length)
    }
}
