class KotlinTest2 {
    inline fun acceptLambda(lambda: (String) -> Int) {
        val retVal = lambda("Test")
    }

    fun runExample() {
        acceptLambda {
           string -> string.length 
        }
    }
}
