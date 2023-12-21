package org.bishop.FinalSection;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambda {

    public static void main(String[] args) {

        System.out.println(upperCase.apply("India"));
        System.out.println(sum.apply(2,3));
        System.out.println(sumWithPrint.apply(5,2));
    }

/*    The reason why we are using Integer instead or int because we cannot
*     assign int = null beacuse its is primitive datatype
*       that's why we are using wrapper class Integer class due to which we can pass null
* */
    static Function<String,String> upperCase = name -> name.toUpperCase();

    static BiFunction<Integer,Integer,Integer> sum = (a,b) -> a+b;

    static  BiFunction<Integer,Integer,Integer> sumWithPrint =(a,b) -> {
        System.out.println("Adding a = "+a+ " b= " +b);
        return a+b;
    };
}
