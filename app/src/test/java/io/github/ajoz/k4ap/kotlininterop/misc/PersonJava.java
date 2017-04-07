package io.github.ajoz.k4ap.kotlininterop.misc;

public class PersonJava {
    public final String name;
    public final String surname;
    public final int age;

    public PersonJava(final String name, final String surname, final int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonJava)) return false;

        final PersonJava that = (PersonJava) o;

        if (age != that.age) return false;
        if (!name.equals(that.name)) return false;
        return surname.equals(that.surname);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "PersonJava{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
