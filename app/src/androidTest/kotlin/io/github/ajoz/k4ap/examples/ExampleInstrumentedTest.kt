package io.github.ajoz.k4ap.examples

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.assertEquals

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    // Missing default empty constructor might cause some issues or might not ;-)
    constructor() {}

    @Test
    @Throws(Exception::class)
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()

        assertEquals("io.github.ajoz.k4ap", appContext.packageName)
    }
}
