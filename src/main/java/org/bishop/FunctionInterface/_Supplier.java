package org.bishop.FunctionInterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {

    public static void main(String[] args) {

        //Supplier takes no argument and returns a result
        System.out.println(getDbJbbcUrl());
        System.out.println(getDbJbbcUrlSupplier.get());
        System.out.println(getGetDbJbbcUrlSupplierList.get());
    }

    public static String getDbJbbcUrl()
    {
        return "jdbc://mysql/localhost:3306/mygateway";
    }

    static Supplier<String> getDbJbbcUrlSupplier=()->"jdbc://mysql/localhost:3306/mygateway";

    static Supplier<List<String>> getGetDbJbbcUrlSupplierList = ()->List.of(
            "jdbc://mysql/localhost:3306/mygateway",
            "jdbc://mysql/localhost:3306/CoreEngine",
            "jdbc://mysql/localhost:3306/IVRSecurity",
            "jdbc://mysql/localhost:3306/Scheduler"
    );

}
