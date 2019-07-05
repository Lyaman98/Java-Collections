package com.example.stream.api;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        //without Stream API
        print();

        //with Stream API
        long count = IntStream.of(-4,-6,-7,2,1,3).filter(i -> i > 0).count();
        System.out.println(count);

        System.out.println("-----------------------------------");
        ArrayList<String> cities = new ArrayList<>();
        Collections.addAll(cities,"Paris","London","Baku");

        //via stream() method we are getting the stream to manipulate with data
        cities.stream()
                .filter(s -> s.length() < 6)
                .forEach(System.out::println);

        //creating object of Stream type
        Stream<String> stream = cities.stream();

        System.out.println("-----------------------------------");
        //we could also define stream like this
        stream = Arrays.stream(new String[]{"Paris","Baku"});

        stream.forEach(System.out::println);


        //map method converts object of one type to another
        //<R> Stream<R> map(Function<? super T, ? extends R> mapper)

        System.out.println("-----------------------------------");
        List<Phone> phoneStream = Arrays.asList(new Phone("Iphone 6s",1400),
                new Phone("Lumia 950",  1500),  new Phone("Samsung Galaxy S 6", 2000));

        phoneStream
                .stream()
                .filter(phone -> phone.getPrice() < 1600)
                .map(Phone::getPhoneName)
                .forEach(System.out::println);

        System.out.println("-----------------------------------");

        //flatMap - when from one element we should get several elements of one type
        //<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)65
        phoneStream
                .stream()
                .flatMap(p->Stream.of(
                        String.format("Phone name %s" , p.getPhoneName()),
                        String.format("Price %f" , p.getPrice())
                ))
                .forEach(System.out::println);
    }

    private static void print(){
        int [] numbers = {-4,-6,-7,2,1,3};
        int count = 0;

        for (int i : numbers){
            if (i > 0) count++;
        }

        System.out.println(count);
    }
}
