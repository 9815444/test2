package test5;

import java.util.function.Predicate;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Predicate<Person> isOlderPredicate() {
//        return this.age > person.age; // реализуйте этот метод здесь
//        Predicate<Person> personPredicate =  new Predicate<Person>() {
//            @Override
//            public boolean test(Person person) {
//                return age < person.age;
//            }
//        };
        Predicate<Person> personPredicate = person -> {return age < person.age;};
        return personPredicate;
    }
}

public class Practicum {

    public static void main(String[] args) {
        Person kostya = new Person("Костя", 5);

        System.out.println(kostya.isOlderPredicate().test(new Person("Старше", 10))); // true
        System.out.println(kostya.isOlderPredicate().test(new Person("Младше", 3))); // false
    }
}