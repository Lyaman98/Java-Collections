package com.example.lambdas;

import java.util.function.*;

public class LambdaApp {

    public static void main(String[] args) {

        Operationable operationable = (x,y)->x+y;
        System.out.println(operationable.calculate(20,20));

        Expression expression = (n)->n%2==0;
        int [] numbs = {1,2,4,5,6,8};
        System.out.println(sum(numbs,expression));

        Operationable result = action(3);
        System.out.println("Multiplication is " + result.calculate(30,20));

        //checks the condition and returns boolean value
        Predicate<Integer> isPositive = x->x>0;
        System.out.println(isPositive.test(-12));

        //accepts two values and returns the result
        BinaryOperator<Integer> multiply = (x,y)->x*y;
        System.out.println(multiply.apply(12,2));

        //accepts type T and returns type R
        Function<Integer,String> convert = x-> x + " dollars";
        System.out.println(convert.apply(12));

        //returns nothing, accepts value of type T
        Consumer<Integer> consumer = x-> System.out.println("The number is " + x);
        consumer.accept(12);

        //returns value of type T and accepts nothing
        Supplier<Integer> supplier = ()-> {
            Integer sum = 233+232;
            return sum;
        };
        System.out.println(supplier.get());


    }

    //sending lambda as a parameter to the method
    private static int sum(int [] numbers, Expression expression){
        int result = 0;

        for (int i : numbers){
            if (expression.isEqual(i)){
                result += i;
            }
        }

        return result;
    }

    //returning lambda from the method
    private static Operationable action(int i){

        switch (i){
            case 1 : return (x,y)->x+y;
            case 2 : return (x, y) -> x-y;
            case 3: return (x, y) -> x*y;
            default:return (x, y) -> 0;
        }

    }

}
