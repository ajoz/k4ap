package io.github.ajoz.k4ap.examples.kotlintest

import io.kotlintest.matchers.shouldBe
import io.kotlintest.properties.forAll
import io.kotlintest.properties.headers
import io.kotlintest.properties.row
import io.kotlintest.properties.table
import io.kotlintest.specs.StringSpec

/**
 * KotlinTest is a flexible and comprehensive testing tool for Kotlin.
 * https://github.com/kotlintest/kotlintest
 */
class KotlinTestExampleTest : StringSpec() {
    init {
        "length should return size of string" {
            "Kotlin4AndroidProgrammers".length shouldBe 25
        }

        "string size" {
            forAll { a: String, b: String ->
                (a + b).length == a.length + b.length
            }
        }

        // Spock does this better!
        "should add all integers from given table" {
            val myTable = table(
                    headers("a", "b", "result"),
                    row(1, 2, 3),
                    row(1, 1, 2)
            )
            forAll(myTable) { a, b, result ->
                a + b shouldBe result
            }
        }
    }
}