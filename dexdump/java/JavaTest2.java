public class JavaTest2 {
    public interface Lambda<A, R> {
        public R invoke(A value);
    }

    public void acceptLambda(final Lambda<String, Integer> lambda) {
        final Integer retVal = lambda.invoke("Test");
    }

    public void runExample() {
        acceptLambda(new Lambda<String, Integer>() {
            public Integer invoke(final String value) {
                return value.length();
            }
        });
    }
}
