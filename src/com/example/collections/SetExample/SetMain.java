package com.example.collections.SetExample;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMain {

    public static void main(String[] args) {

        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i = 1; i <= 100; i++){
            squares.add(i*i);
            cubes.add(i*i*i);
        }

        System.out.println("There are " + squares.size() + " squares and " + cubes.size() + " cubes");
        Set<Integer> union = new HashSet<>(squares);
        //to add new collection to the existing one
        union.addAll(cubes);
        System.out.println("Union contains " + union.size() + " elements");

        //to get intersection of two collections
        Set<Integer> interSection = new HashSet<>(squares);
        interSection.retainAll(cubes);
        System.out.println("Intersection contains " + interSection.size() + " elements");


        //to get the elements that are in the first collection, but no in the second - A/B
        Set<Integer> diff = new HashSet<>(squares);
        diff.removeAll(cubes);
        System.out.println("There are " + diff.size() + " elements");


        Set<String> words = new HashSet<>();
        String sentence = "This is the example";
        String [] arraywords = sentence.split(" ");

        //will be added in random order
        words.addAll(Arrays.asList(arraywords));

    }
}
