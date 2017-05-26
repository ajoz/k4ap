package io.github.ajoz.k4ap.dummy

import io.github.ajoz.k4ap.BuildConfig
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class)
class DummyContextTest2 {
    @Test
    fun shouldCreateDummyItemForPosition0() {
        //given
        val position = 1
        //when:
        val (id, content, _) = DummyContent.items[0]
        //then:
        assertEquals("$position", id)
        assertEquals("K4AP Item $position", content)
    }
}