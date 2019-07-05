package com.example.interfaces;

import java.util.Date;

public interface Printable {

    void print();

    //now from JDK 8 we can add default methods with implementation
    //it is not necessary to override this method from the class
    default void dateOfPrinting(){
        System.out.println(new Date());
    }

    //from JDK 8 we can define static methods in interfaces
    static void publisher(){
        System.out.println("Publisher");
    }

}
