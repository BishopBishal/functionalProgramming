package org.bishop.Optional;

import java.util.Optional;

public class _Optional {
    public static void main(String[] args) {

        System.out.println(Optional.empty().orElseGet(() -> "The default value"));
        try {
            System.out.println(Optional.empty().orElseThrow(() -> new IllegalArgumentException("Exception Occurred Null Value has passed for the optional Variable")));
        } catch (Exception e) {
            System.out.println("Exception occurred " + e.getMessage());
        }
        Optional.ofNullable("john").ifPresentOrElse(System.out::println, () ->
            System.out.println("Can't say your name as it is empty")
        );
    }
}
