package org.bishop.LambdaPractice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise1 {

    public static void main(String[] args) {

        //1. Write a Java program to implement a lambda expression to find the sum of two integers.
        System.out.println(PractiseClass.sumOfNumber.apply(1, 4));

        //2. Write a Java program to implement a lambda expression to check if a given string is empty.
        System.out.println(PractiseClass.checkStringEmpty.apply(""));

        //5. Write a Java program to implement a lambda expression to sort a list of strings in alphabetical order.
        List<String> customers = Arrays.asList("zaren", "kira", "eabi", "sabrina", "mena", "hena");
        System.out.println("Older customer Array - " + customers);
        System.out.println(PractiseClass.sortTheStringArray.apply(customers));

        //6. Write a Java program to implement a lambda expression to find the average of a list of doubles.
        System.out.println("Average = "+PractiseClass.findAverage.apply(Arrays.asList(1.3,3.3,5.5,7.77,73.2)));

        //7. Write a Java program to implement a lambda expression to remove duplicates from a list of integers.
        System.out.println("Unique Set of Integer = "+PractiseClass.removeDuplicate.apply(Arrays.asList(1,2,5,1,2,5,32,52,4,2,5,32)));

        //8. Write a lambda expression to implement a lambda expression to calculate the factorial of a given number.
        System.out.println("factorial "+PractiseClass.calculateFactorial(5));

        //9. Write a Java program to implement a lambda expression to create a lambda expression to check if a number is prime.
        System.out.println("isNotAprimeNumber -> "+PractiseClass.primeNumberFunction.apply(120));

        //10. Write a Java program to implement a lambda expression to concatenate two strings.
        System.out.println("Concated String - "+PractiseClass.concatTwoString.apply("hello"," bro"));

    }


}


class PractiseClass {
    static BiFunction<Integer, Integer, Integer> sumOfNumber = (a, b) -> a + b;


    static Function<String, Boolean> checkStringEmpty = word -> word.isEmpty();

    static Function<List<String>, List<String>> sortTheStringArray = strings -> {
        Collections.sort(strings);
        return strings;
    };

    static Function<List<Double>, Double> findAverage = numberlist -> {
        Double sum=numberlist.stream().mapToDouble(Double::doubleValue).sum();
       return sum/numberlist.size();
    };

    static Function<List<Integer>,List<Integer>> removeDuplicate = numberList -> numberList.stream().collect(Collectors.toSet()).stream().toList();

 static int calculateFactorial(int num)
 {
     IntUnaryOperator factorial = x -> IntStream.rangeClosed(1,x).reduce(1,(a,b) -> a*b);
     return factorial.applyAsInt(num);
 }


     static  Function<Integer,Boolean> primeNumberFunction = prime -> IntStream.rangeClosed(2,prime-1)
             .anyMatch(x -> prime%x==0);

    static  BiFunction<String,String,String> concatTwoString =(a,b) ->a.concat(b);

}