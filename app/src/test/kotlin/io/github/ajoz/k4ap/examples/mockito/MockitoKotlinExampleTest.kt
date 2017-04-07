package io.github.ajoz.k4ap.examples.mockito

import com.nhaarman.mockito_kotlin.*
import org.junit.Test

/**
 * A small library that provides helper functions to work with Mockito in Kotlin.
 * https://github.com/nhaarman/mockito-kotlin
 */
class MockitoKotlinExampleTest {
    @Suppress("IllegalIdentifier")
    @Test
    fun `Should mock example interface with Mockito the Kotlin way`() {
        //given:
        val mock = mock<ThisBegsForMocking> {
            on { foo() } doReturn 25
            on { bar() } doReturn "Kotlin4AndroidProgrammers"
        }

        //when:
        mock.foo()

        //then
        verify(mock, times(1)).foo()
        verify(mock, never()).bar()
    }
}

interface ThisBegsForMocking {
    fun foo(): Int
    fun bar(): String
}