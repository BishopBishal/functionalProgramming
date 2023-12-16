package org.bishop.FunctionInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {

        //Examples of Function - It takes one argument and results in one output
        int incrementvalue1=incrementByOne(1);
        System.out.println(incrementvalue1);
        System.out.println("incrementByOneFunction.apply(1) = "+incrementByOneFunction.apply(1));
        Function<Integer,Integer> multiplyBy10Function =number -> number*10;
        Function<Integer, Integer> incrementBy1AndMultiply10 = incrementByOneFunction.andThen(multiplyBy10Function);
        System.out.println("incrementBy1AndMultiply10 = " + incrementBy1AndMultiply10.apply(1));

        //Examples of BiFunction - it takes 2 argument and result in one output
        System.out.println(incrementByOneAndMultiple(4,25));
        System.out.println("incrementByOneAndMutilplyFunction = " +incrementByOneAndMutilplyFunction.apply(4,25));
    }

    static Function<Integer,Integer>incrementByOneFunction=number->number+1;
    public static int incrementByOne(int number)
    {
        return number+1;
    }

    public static int incrementByOneAndMultiple(int x,int y)
    {
        return (x+1)*y;
    }

    public static BiFunction<Integer,Integer,Integer> incrementByOneAndMutilplyFunction=
            (x,y)->(x+1)*y;

}
