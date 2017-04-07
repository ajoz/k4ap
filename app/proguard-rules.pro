# In case of mysterious errors while proguarding
#-dontwarn kotlin.**

# Proguard can strip out mappings for enums in when expressions
# if your using a lot of enums it's worth to add this line
-keepclassmembers class **$WhenMappings {
    <fields>;
}

# This will tell Kotlin to remove null checks for runtime
-assumenosideeffects class kotlin.jvm.internal.Intrinsics {
    static void checkParameterIsNotNull(java.lang.Object, java.lang.String);
}