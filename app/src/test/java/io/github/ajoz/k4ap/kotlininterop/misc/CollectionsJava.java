package io.github.ajoz.k4ap.kotlininterop.misc;

import java.util.Arrays;
import java.util.List;

public class CollectionsJava {
    public static List<Integer> getSmallListOfInts() {
        return Arrays.asList(1, 2, 3, 4, 5, 6, 7);
    }

    public static List<PersonJava> getListOfPersons() {
        return Arrays.asList(
                new PersonJava("Java", "Lang", 21),
                new PersonJava("Kotlin", "Lang", 11),
                new PersonJava("Scala", "Lang", 14),
                new PersonJava("Cpp", "Lang", 34),
                new PersonJava("C", "Lang", 45),
                new PersonJava("Fortran", "Lang", 60),
                new PersonJava("JUG", "Lodz", 7),
                new PersonJava("Mobilization", "Conference", 7)
        );
    }
}
