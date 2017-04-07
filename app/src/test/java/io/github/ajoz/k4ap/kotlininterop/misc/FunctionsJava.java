package io.github.ajoz.k4ap.kotlininterop.misc;

public class FunctionsJava {
    public static void acceptAFunction(final String s, final FunctionJava<String, Integer> func) {
        System.out.println("Length of string: " + s + " is " + func.apply(s));
    }

    public static FunctionJava<String, Integer> returnAFunction() {
        return new FunctionJava<String, Integer>() {
            @Override
            public Integer apply(final String value) {
                return value.length();
            }
        };
    }

    public interface FunctionJava<A, R> {
        R apply(A value);
    }
}