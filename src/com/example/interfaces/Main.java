package com.example.interfaces;

public class Main {

    public static void main(String[] args) {

        Printable printable = new Book("War and peace","Leo Tolstoy");
        printable.print();
        printable = new Journal("Foreign Policy");
        printable.print();
        printable.dateOfPrinting();
        Printable.publisher();
    }
}
