package org.bishop.CombinationPattern;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer=new Customer(
          "foo",
          "bar",
          "+9112313123",
                LocalDate.of(2000, 7,20),
                "foobar@gmail.com"
        );

        System.out.println(CustomerValidatorService.isValidCustomer(customer));

        System.out.println(CustomerRegistrationValidator.isValidEmail()
                .and(CustomerRegistrationValidator.isPhoneNumberValid())
                .and(CustomerRegistrationValidator.isCustomerAgeVerfied())
                .apply(customer));

        System.out.println(CustomerRegistrationValidator.isValidEmail()
                .or(CustomerRegistrationValidator.isPhoneNumberValid())
                .or(CustomerRegistrationValidator.isCustomerAgeVerfied())
                .apply(customer));

    }
}
