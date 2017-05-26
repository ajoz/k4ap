package io.github.ajoz.k4ap.dummy

import android.support.test.runner.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Android Instrumentation Tests do not allow the same type of identifiers
 * as normal JUnit / Robolectric tests. You cannot use tests with names containing
 * spaces. Although it compiles it won't be run / recognized on android. If run
 * with gradlew connectedCheck or gradlew connectedAndroidTest it will end with
 * a FAILED cause "com.android.builder.testing.ConnectedDevice > No tests found"
 * */
@Suppress("IllegalIdentifier")
@RunWith(AndroidJUnit4::class)
class DummyContextTest {
    @Test
    fun shouldCreate10DummyItems() {
        //given:
        //when:
        val items = DummyContent.items
        //then:
        assertEquals(DummyContent.count, items.size)
    }
}