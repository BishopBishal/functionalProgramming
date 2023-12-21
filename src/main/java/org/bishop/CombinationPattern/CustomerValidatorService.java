package org.bishop.CombinationPattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {

    public static Boolean isCustomerEmailValid(String email)
    {
        return email.contains("@");
    }

    public static Boolean isCustomerNumberValid(String phoneNumber)
    {
        return phoneNumber.startsWith("+91");
    }

    public static Boolean isCustomerIsAdult(LocalDate dob)
    {
        return Period.between(dob,LocalDate.now()).getYears() > 16;
    }

    public  static Boolean isValidCustomer(Customer customer)
    {
        return isCustomerEmailValid(customer.getEmail())&&
                isCustomerIsAdult(customer.getDob())&&
                isCustomerNumberValid(customer.getPhoneNumber());
    }
}
