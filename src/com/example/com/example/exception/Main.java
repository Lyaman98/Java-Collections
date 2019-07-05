package com.example.com.example.exception;

public class Main {

    public static void main(String[] args) {

        //this will work
        System.out.println(getFactorial(2));
        //this will throw an exception
        System.out.println(getFactorial(-2));

        try {
            System.out.println(mult(1,0));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static int mult(int i, int j) throws Exception{

        if (j == 0){
            throw new Exception("Division by null");
        }
        return i/j;
    }

    private static int getFactorial(int num){
        int result = 1;

        try {
            if (num < 1){
                throw new Exception("The number is less than 1");
            }
            for (int i = 1; i < num; i++){
                result *= i;
            }
        }catch (Exception e){
            e.printStackTrace();
            result = num;
        }

        return result;
    }
}
