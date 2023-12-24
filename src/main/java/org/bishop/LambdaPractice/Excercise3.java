package org.bishop.LambdaPractice;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class Excercise3 {

    public static void main(String[] args) {

        //21. Write a Java program to implement a lambda expression to calculate the sum of all prime numbers in a given range.
        List<Integer> integerList = Arrays.asList(1, 34, 5, 1, 2, 5, 6, 7, 9, 2, 3, 4, 5, 634, 234, 63, 123, 512, 12, 13, 4, 5526, 62);
        System.out.println(PracticesClass.sumOfPrimeNumber.apply(1,10));

        //22. Write a Java program to implement a lambda expression to check if a list of strings are all uppercase or all lowercase or mixedcase.

        List<String> stringList = Arrays.asList("Hello", "SUPPER", "toppers");
        System.out.println("Casing of the List is - "+PracticesClass.checkforCaseing(stringList));
        //23. Write a Java program to implement a lambda expression to find the average length of strings in a list.

        System.out.println("Total Length of the strings in list - "+PracticesClass.avgLengthOfStringList.apply(stringList));

        //24. Write a Java program to implement a lambda expression to find the largest prime factor of a given number.
        System.out.println("Largest prime factor of the number - "+PracticesClass.largestPrimeFactor.apply(119));
        //25. Write a Java program to implement a lambda expression to convert an integer to their corresponding binary representation.

        System.out.println(" binary representation - "+PracticesClass.integerToBinary.apply(12));


    }
}

class PracticesClass {

    static BiFunction<Integer,Integer,Integer> sumOfPrimeNumber = (a,b) -> IntStream.rangeClosed(a,b).filter(x -> IntStream.rangeClosed(2, x - 1)
            .noneMatch(r -> x % r == 0)).reduce(Integer::sum).getAsInt();

    static Function<List<String>,Boolean> checkForLowerCase = x -> x.stream().allMatch(s -> s.equals(s.toLowerCase()));
    static Function<List<String>,Boolean> checkForUpperCase= x -> x.stream().allMatch(s -> s.equals(s.toUpperCase()));

    static String checkforCaseing(List<String> s){
        if(checkForUpperCase.apply(s))
            return "UpperCase";
        else if(checkForLowerCase.apply(s))
            return "LowerCase";
        else
            return "MixCase";
    }


    static Function<List<String>,Integer> avgLengthOfStringList = x -> x.stream().mapToInt(String::length).sum()/x.size();

    static  Function<Integer,String> integerToBinary = Integer::toBinaryString;

    static Function<Integer,Integer> largestPrimeFactor =x -> IntStream.rangeClosed(2,x-1)
            .filter(s -> x%s ==0)
            .peek(z -> System.out.println("factors -  "+z))
            .filter(d -> IntStream.rangeClosed(2,d-1).noneMatch(t -> d%t ==0 ))
            .peek(f -> System.out.println("Prime Factors - "+f))
            .max().getAsInt();
}



