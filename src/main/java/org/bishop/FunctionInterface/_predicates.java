package org.bishop.FunctionInterface;

import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _predicates {


    public static void main(String[] args) {

        //Predicate takes a parameter returns a Boolean value after checking
        System.out.println(phoneNumberPrefixIsValid("+910111111")&&phoneNumberLength10IsValid("+910111111"));
        System.out.println(phoneNumberPrefixIsValid("+9101111111")&&phoneNumberLength10IsValid("+9101111111"));
        System.out.println(phoneNumberPrefixIsValid("+190111111")&&phoneNumberLength10IsValid("+190111111"));
        System.out.println(phoneNumberPrefixIsValidPredicate.and(phoneNumberLength10IsValid).test("+910111111"));
        System.out.println(phoneNumberPrefixIsValidPredicate.and(phoneNumberLength10IsValid).test("+9101111111"));
        System.out.println(phoneNumberPrefixIsValidPredicate.and(phoneNumberLength10IsValid).test("+190111111"));



        //BiPredicate takes two parameter and return a Boolean
        System.out.println("BiPredicate Testing ");
        System.out.println(checkTwoPhoneNumberHasEqualLength.test("+910111111","+9101111111"));
        System.out.println(checkTwoPhoneNumberHasEqualLength.test("+9101111111","+190111111"));
        System.out.println(checkTwoPhoneNumberHasEqualLength.test("+190111111","+910111111"));
        System.out.println(checkTwoPhoneNumberHasEqualLength.or(checkTwoPhoneNumberStartsWithSamePrefix).test("+910111111","+9101111111"));
        System.out.println(checkTwoPhoneNumberHasEqualLength.or(checkTwoPhoneNumberStartsWithSamePrefix).test("+9101111111","+190111111"));
        System.out.println(checkTwoPhoneNumberHasEqualLength.or(checkTwoPhoneNumberStartsWithSamePrefix).test("+190111111","+910111111"));
    }

    public static Boolean phoneNumberPrefixIsValid(String number)
    {
        return number.startsWith("+91") ;
    }
    public static  Boolean phoneNumberLength10IsValid(String number)
    {
        return number.length()==10 ;
    }
    static Predicate<String> phoneNumberPrefixIsValidPredicate = number -> number.startsWith("+91");
    static Predicate<String> phoneNumberLength10IsValid = number -> number.length()==10;

    static BiPredicate<String,String> checkTwoPhoneNumberHasEqualLength = (phoneNumber1 ,phoneNumber2) ->phoneNumber1.length()==phoneNumber2.length();
    static BiPredicate<String,String> checkTwoPhoneNumberStartsWithSamePrefix = (phoneNumber1 ,phoneNumber2) ->phoneNumber1.substring(3).equalsIgnoreCase(phoneNumber2.substring(3));

}


