package io.github.ajoz.k4ap.kotlininterop;


import edu.emory.mathcs.backport.java.util.Collections;
import io.github.ajoz.k4ap.javainterop.misc.*;
import io.github.ajoz.k4ap.kotlininterop.misc.PersonJava;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty1;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class KotlinInteropTest {
    @Test
    public void shouldBeAbleToCallKotlinPersonClass() throws Exception {
        final PersonKotlin personKotlin = new PersonKotlin("Kotlin4", "AndroidDevelopers", 25);
        System.out.println(personKotlin.getName());
        System.out.println(personKotlin.getSurname());
        System.out.println(personKotlin.getAge());
        System.out.println(personKotlin);
    }

    @Test
    public void shouldBeAbleToGetKotlinCollection() throws Exception {
        final List<Integer> smallListOfInts = CollectionsKotlin.INSTANCE.getSmallListOfInts();
        System.out.println(smallListOfInts);
    }

    @Test
    public void shouldBeAbleToProcessTheKotlinCollection() throws Exception {
        final List<PersonKotlin> persons = CollectionsKotlin.INSTANCE.getListOfPersons();

        //No separation of concerns (non lazy)

        final List<String> filtered = new ArrayList<>(); /*Filtering*/
        for (final PersonKotlin person : persons) {      /*Filtering*/
            if (person.getAge() > 7) {                   /*Filtering*/
                filtered.add(person.getName().toUpperCase()); /*Filtering + Mapping*/
            }
        }

        Collections.sort(filtered); /*Sorting*/

        final List<String> strings; /*Taking 3 or less*/
        if (!filtered.isEmpty()) {  /*Taking 3 or less*/
            strings = filtered.subList(0, Math.min(3, filtered.size())); /*Taking 3 or less*/
        } else { /*Taking 3 or less*/
            strings = Collections.emptyList(); /*Taking 3 or less*/
        }
        System.out.println(strings);
    }

    //how to do lazy processing on Java 6 without Stream? Using iterators?
    //another library? Will types be compatible with Java?


    @Test
    public void shouldAcceptAFunction() throws Exception {
        FunctionsKotlin.INSTANCE.acceptAFunction("Kotlin4AndroidProgrammmers", new Function1<String, Integer>() {
            @Override
            public Integer invoke(final String s) {
                return s.length();
            }
        });
    }

    @Test
    public void shouldReturnAFunction() throws Exception {
        final Function1<String, Integer> func1 = FunctionsKotlin.INSTANCE.returnAFunction();
        final Integer value1 = func1.invoke("Kotlin4AndroidProgrammers");
        System.out.println("Value returned by this function: " + value1);

        //in Kotlin this function returns a reference
        //KProperty1 extends Function1
        final KProperty1<String, Integer> func9 = FunctionsKotlin.INSTANCE.returnAFunction9();
        final Integer value9 = func9.invoke("Kotlin4AndroidProgrammers");
        System.out.println("Value returned by this function: " + value9);
    }

    @Test
    public void shouldUseOverloadedConstructors() throws Exception {
        final Item itemWithName = new Item("Only a Name");
        final Item itemWithNameAndValue = new Item("Name and a Value", 42);
        System.out.println(itemWithName);
        System.out.println(itemWithNameAndValue);
    }

    @Test
    public void shouldUseExtensionMethods() throws Exception {
        final PersonKotlin personKotlin = new PersonKotlin("Kotlin4", "AndroidDevelopers", 25);
        final PersonJava personJava = MiscStuffKt.toJava(personKotlin);
        System.out.println(personJava);
    }
}
