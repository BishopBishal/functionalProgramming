package org.bishop.Imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        List<person> collectionPerson = List.of(new person("foo", "barr", 23, person.Gender.MALE),
                new person("loo", "baar", 24, person.Gender.FEMALE),
                new person("Tss", "asdad", 43, person.Gender.FEMALE),
                new person("LOJ", "LSf", 51, person.Gender.MALE),
                new person("ASda", "sda", 60, person.Gender.LGBTQ),
                new person("Test", "SMLIA", 92, person.Gender.Others));

        //Information Approach to find the females only
        List<person> females = new ArrayList<>();
        for (person p : collectionPerson) {
            if (p.gender.equals(person.Gender.FEMALE)) {
                females.add(p);
            }
        }
        for (person female : females) {
            System.out.println(female);
        }


        //Declarative Approach to find females
        System.out.println("Declarative approach");


        List<person> declarativeFemales = collectionPerson.stream().filter(person -> person.gender
                        .equals(Main.person.Gender.FEMALE))
                .collect(Collectors.toList());
        declarativeFemales.forEach(System.out::println);

//                                    forEach(System.out::println);


    }

    public static class person {
        private final String firstName;
        private final String lastName;

        private final int age;

        private final Gender gender;

        @Override
        public String toString() {
            return "person{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", age=" + age + ", gender=" + gender + '}';
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        public Gender getGender() {
            return gender;
        }

        public person(String firstName, String lastName, int age, Gender gender) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.gender = gender;
        }

        enum Gender {
            MALE, FEMALE, LGBTQ, Others
        }


    }
}