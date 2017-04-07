package io.github.ajoz.k4ap.examples.robolectric

import android.content.Context
import io.github.ajoz.k4ap.BuildConfig
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.collection.IsIterableWithSize
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertThat
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

/**
 * Robolectric is a unit test framework that de-fangs the Android SDK jar so you can test-drive the development of your
 * Android app. Tests run inside the JVM on your workstation in seconds.
 * http://robolectric.org/
 */
@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class)
class RobolectricExampleTest {

    @Test
    fun shouldPassAVanillaTest() {
        assertTrue(true)
    }

    @Test
    fun shouldPassATestWithMockito() {
        //given:
        val mocked: Foo = mock(Foo::class.java)
        `when`(mocked.bar()).thenReturn(true)
        //when:
        mocked.bar()
        //then:
        verify(mocked, times(1)).bar()
    }

    @Test
    fun shouldPassATestWithHamcrest() {
        //given:
        val normal = listOf(1, 2, 3, 4, 5)
        val reversed = normal.reversed()
        //when:
        val sum = reversed.sum()
        //then:
        assertThat(reversed, IsIterableWithSize(`is`(normal.size)))
        assertThat(sum, equalTo(normal.sum()))
    }

    @Test
    fun shouldPassATestWithRobolectric() {
        //given:
        val context = RuntimeEnvironment.application
        //when:
        val sharedPreferences = context.getSharedPreferences("K4AP", Context.MODE_PRIVATE)
        val edit = sharedPreferences.edit()
        edit.putBoolean("K4AP_ShouldIGiveKotlinATry", true)
        val success = edit.commit()
        //then:
        assertTrue(success)
    }
}

interface Foo {
    fun bar(): Boolean
}