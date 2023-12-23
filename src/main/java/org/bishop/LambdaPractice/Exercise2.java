package org.bishop.LambdaPractice;

import java.time.Period;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise2 {
    public static void main(String[] args) {
        //11. Write a Java program to implement a lambda expression to find the maximum and minimum values in a list of integers.
        List<Integer> integerList = Arrays.asList(1, 3, 5, 6, 82, 234, 883, 242, 234, 732, 2342, 2, 23, 2, 234, 24);
        System.out.println("Max is - "+ PracticeClass.findMax.apply(integerList) + " Min is - "+PracticeClass.findMin.apply(integerList));

        //12. Write a Java program to create a lambda expression to multiply and sum all elements in a list of integers.
        System.out.println("Sum of List - "+PracticeClass.findSumofList.apply(integerList) + " Multiply of the List - "+PracticeClass.findMultiplyofList.apply(integerList));

        //13. Write a Java program to implement a lambda expression to count words in a sentence.
        System.out.println("Count of Words - "+PracticeClass.countWordInSentence.apply(" hello bro where were you ?"));

        //14. Write a Java program to implement a lambda expression to check if a given string is a palindrome.
        System.out.println("Is it Palindrome - "+PracticeClass.checkPalindrome.apply("level"));

        //15. Write a Java program to implement a lambda expression to calculate the sum of squares of all odd and even numbers in a list.
         integerList = Arrays.asList( 1,3, 5, 6, 82,  2, 23, 2, 234, 24);
        System.out.println("Sum of Odd square number= "+PracticeClass.sumOfSquareOddNumber.apply(integerList) +" Sum of Even square number= "+PracticeClass.sumOfSquareEvenNumber.apply(integerList));

        //16. Write a Java program to implement a lambda expression to check if a list of strings contains a specific word.

        List<String> stringList = Arrays.asList( "hellos","boys", "how", "are", "you", "find", "me");
        System.out.println("Is Word in String = "+PracticeClass.checkWordInSentence.apply(stringList,"how"));

        //17. Write a Java program to implement a lambda expression to find the length of the longest and smallest string in a list.
        System.out.println("Longested string length in the array is - "+PracticeClass.longestStringInList.apply(stringList) + " smallest string length in array is - "+PracticeClass.smallestStringInList.apply(stringList));

        //18. Write a Java program to implement a lambda expression to check if a given number is a perfect square.
        System.out.println("Is Number Perfect Square - "+ PracticeClass.checkPerfectSquare.apply(4));

        //19. Write a Java program to implement a lambda expression to find the second largest and smallest element in an array.
        System.out.println("Second smallestElement is - "+PracticeClass.findSecondSmallest.apply(integerList) + " Second LargestElement is - "+PracticeClass.findSecondLargest.apply(integerList));

        //20. Write a Java program to implement a lambda expression to sort a list of objects based on a specific attribute.
        Person person1 =new Person("hira",23);
        Person person2 =new Person("thakur" ,21);
        List<Person> personList = Arrays.asList(person1, person2);
        System.out.println("Sort person based on age - "+PracticeClass.sortPersonOnAge.apply(personList) + " Sort person based on Name - "+PracticeClass.sortPersonOnName.apply(personList));

    }
}
class PracticeClass{

    static  Function<List<Integer>,Integer> findMax = x -> Collections.max(x);

    static  Function<List<Integer>,Integer> findMin = x -> Collections.min(x);

    static Function<List<Integer>,Integer> findSumofList = x -> x.stream().reduce((a,b) -> a+b).get();
    static Function<List<Integer>,Integer> findMultiplyofList = x -> x.stream().reduce((a,b) -> a*b).get();

    static Function<String,Long> countWordInSentence = x -> Arrays.stream(x.strip().split(" ")).count();



     static Function<String,Boolean> checkPalindrome =x -> IntStream.rangeClosed(0, x.length() / 2).allMatch(i -> x.charAt(i) == x.charAt(x.length() - i - 1));

     static Function<List<Integer>,Integer> sumOfSquareOddNumber = x -> x.stream()
             .filter(p -> p%2!=0)
             .map(s -> s*s)
             .reduce((a,b) -> a+b).get();
    static Function<List<Integer>,Integer> sumOfSquareEvenNumber = x -> x.stream()
            .filter(p -> p%2==0)
            .map(s -> s*s)
            .reduce((a,b) -> a+b).get();

    static BiFunction<List<String>,String,Boolean> checkWordInSentence = (a,b) -> a.contains(b);

/*    static Function<List<String>,Integer> longestStringInList = x -> x.stream()
            .max((o1, o2) -> {
                System.out.println("o1 -" +o1 + " o2 - "+o2);
                if(o1.length() > o2.length())
                {
                    return 1;
                } else if ( o1.length() == o2.length()) {
                return 0;
                }
                return -1;
            })
            .get().length();
    */

    static Function<List<String>,Integer> longestStringInList= x -> x.stream().max(Comparator.comparingInt(String::length)).get().length();

    static Function<List<String>,Integer> smallestStringInList= x -> x.stream().min(Comparator.comparingInt(String::length)).get().length();

    static  Function<Integer,Boolean> checkPerfectSquare = x -> {
        Double root=Math.sqrt(x);
        System.out.println("root - "+root + " float value - "+root%1);
        if(root.isInfinite())
            return false;
        else if(root%1>0)
            return false;
        else
            return true;
    };

    static Function<List<Integer>,Integer> findSecondSmallest = x -> x.stream().sorted().skip(1).toList().get(0);

    static Function<List<Integer>,Integer> findSecondLargest = x -> x.stream().sorted().skip(x.size()-2).toList().get(0);

    static Function<List<Person>,List<Person>> sortPersonOnAge =x -> x.stream().sorted((o1, o2) ->
    {
        if(o1.getAge()>o2.getAge())
            return 1;
        else if (o1.getAge()==o2.getAge())
            return 0;
        else
            return -1;
    }).collect(Collectors.toList());

    static Function<List<Person>,List<Person>> sortPersonOnName = x -> x.stream().sorted(Comparator.comparing(Person::getName)).collect(Collectors.toList());
}



class Person{
    private String name;
    private int age;

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}