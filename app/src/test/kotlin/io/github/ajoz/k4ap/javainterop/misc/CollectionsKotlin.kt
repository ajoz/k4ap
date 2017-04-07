package io.github.ajoz.k4ap.javainterop.misc

object CollectionsKotlin {
    fun getSmallListOfInts() = arrayListOf(1, 2, 3, 4, 5, 6, 7)

    fun getListOfPersons() = arrayListOf<PersonKotlin>(
            PersonKotlin(name = "Java", surname = "Lang", age = 21),
            PersonKotlin("Kotlin", "Lang", 11),
            PersonKotlin("Scala", "Lang", 14),
            PersonKotlin("Cpp", "Lang", 34),
            PersonKotlin("C", "Lang", 45),
            PersonKotlin("Fortran", "Lang", 60),
            PersonKotlin("JUG", "Lodz", 7),
            PersonKotlin("Mobilization", "Conference", 7)
    )
}