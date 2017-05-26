package io.github.ajoz.k4ap.dummy

object DummyContent {
    const val count = 10
    val items by lazy {
        (1..count).map {
            DummyItem(it.toString(), "K4AP Item $it", createDetails(it))
        }
    }

    fun createDetails(position: Int) =
            (0..position - 1)
                    .fold("Details about Item: $position") {
                        b, v ->
                        "$b\nMore details information here about item $v"
                    }

    data class DummyItem(val id: String, val content: String, val details: String = "")
}
