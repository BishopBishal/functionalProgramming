package org.bishop.FunctionInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {

        //Consumer example
        Customer newCustomer = new Customer("Foo", "France");
        greetCustomer(newCustomer);
        greetCustomerConsumer.accept(newCustomer);

        //BiConsumer example
        greetCustomerConsumerV2.accept(newCustomer,true);
        greetCustomerv2(newCustomer,false);


    }

    public static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Greeting to Our Special Customer which happens to be consumer also  :-"
                    + customer);


    public static BiConsumer<Customer,Boolean> greetCustomerConsumerV2 = (customer,showAddress) ->
            System.out.println("Greeting to Our Special Customer which happens to be consumer also  :-"
                    + customer.getName() + " and his address is :- "+(showAddress ? customer.getAddress():"*****"));

    public static void greetCustomer(Customer customer) {
        System.out.println("Greeting to Our Special Customer :-" + customer);
    }
    public static void greetCustomerv2(Customer customer,Boolean showAddress) {
        System.out.println("Greeting to Our Special Customer :-" + customer.getName() + "and his address is : - "+(showAddress? customer.getAddress():"*******"));
    }

    static class Customer {
        public final String Name;
        public final String Address;

        public Customer(String name, String address) {
            Name = name;
            Address = address;
        }

        public String getName() {
            return Name;
        }

        public String getAddress() {
            return Address;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "Name='" + Name + '\'' +
                    ", Address='" + Address + '\'' +
                    '}';
        }
    }

}
