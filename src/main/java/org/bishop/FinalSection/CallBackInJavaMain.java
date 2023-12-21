package org.bishop.FinalSection;

import java.util.function.Consumer;

public class CallBackInJavaMain {

    public static void main(String[] args) {
        sumOfIntegerByCallback(0,2,(z) -> System.out.println("Either one of the value is null -- other value is + "+z));
        sumOfIntegerByCallbackWithoutParameter(0,2,() -> System.out.println("Either one or both the values are null"));
    }

    static void sumOfIntegerByCallback(int x, int y, Consumer<Integer> callback)
    {
        if(x == 0 || y == 0 )
        {
            if(x == 0)
                callback.accept(y);
            else
                callback.accept(x);
        }
        else
            System.out.println(x+y);
    }

    static void sumOfIntegerByCallbackWithoutParameter(int x ,int y, Runnable callback)
    {
        if(x == 0 || y == 0 )
        {
            if(x == 0)
                callback.run();
            else
                callback.run();
        }
        else
            System.out.println(x+y);
    }

}



//In JavaScript we have Concept of Callback we can achieve this aslo in java
//Below is the example of code in JavaScript
/*

function sum ( x, y,callback)
{
    if(x ==null || y == null)
    {
        callback();
    }
    else {
        console.log(x+y);
    }
}

sum(1,null,function(){ console.log("either one of the value is null")})


*/
