package org.bishop.Streams;


import java.util.List;
import java.util.stream.Collectors;

import static org.bishop.Streams._Streams.person.Gender.FEMALE;

public class _Streams {


    public static void main(String[] args) {
        List<person> collectionPerson = List.of(
                new person("foo", "barr", 23, person.Gender.MALE),
                new person("loo", "baar", 24, FEMALE),
                new person("Tss", "asdad", 43, FEMALE),
                new person("LOJ", "LSf", 51, person.Gender.MALE),
                new person("ASda", "sda", 60, person.Gender.LGBTQ),
                new person("Test", "SMLIA", 92, person.Gender.Others));


        collectionPerson.stream()
                .map(person::getGender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        collectionPerson.stream()
                .map(person::getFirstName)
                .mapToInt(String::length)
                .forEach(System.out::println);

        System.out.println(collectionPerson.stream().allMatch(person -> FEMALE.equals(person.gender)));
        System.out.println(collectionPerson.stream().anyMatch(person -> FEMALE.equals(person.gender)));
        System.out.println(collectionPerson.stream().noneMatch(person -> FEMALE.equals(person.gender)));
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

