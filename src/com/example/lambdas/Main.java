package com.example.lambdas;

public class Main {
    public static void main(String[] args) {

        Person person = new Person() {
            @Override
            public void getName(String name) {
                System.out.println(name);
            }
        };

        //-----------------------------


        //creating the instance of ThreadClass to begin the thread
        ThreadClass threadClass = new ThreadClass();
        threadClass.start();

        //Here we are using Anonymous Inner class
        //that extends a class i.e. Here a Thread class
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("Child Thread");
            }
        };
        thread.start();
        System.out.println("Main thread");

        //creating thread using lambda expression
        Thread result = new Thread(()-> System.out.println("Thread is created via lambda expression"));
        result.start();
    }
}
