package io.github.ajoz.k4ap.dummy

object DummyContent {
    const val count = 10
    val items by lazy {
        (1..count).map { createItem(it) }
    }

    private fun createItem(position: Int) =
            DummyItem(
                    position.toString(),
                    "K4AP Item $position",
                    createDetails(position)
            )


    private fun createDetails(position: Int) =
            (0..position - 1)
                    .fold(StringBuilder("Details about Item: $position")) {
                        b, v ->
                        b.append("\nMore details information here about item $v")
                    }
                    .toString()

    data class DummyItem(val id: String, val content: String, val details: String = "")
}
