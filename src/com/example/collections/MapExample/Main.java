package com.example.collections.MapExample;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String,String> languages = new HashMap<>();

        languages.put("java", "compiled high level, object-oriented, platform independent language");
        languages.put("python", "an interpreted,object-oriented high level language");
        languages.put("algo", "an algorithmic language");

        //to retrieve an element by key
        System.out.println(languages.get("java"));
        //keys are unique
        languages.put("java","example of overriding the value");
        System.out.println(languages.get("java"));

        //to check if the element exists
        if (languages.containsKey("java")){
            System.out.println("Java is already in the map");
        }else {
            System.out.println("Not found");
        }


        //to remove element from the map
        languages.remove("algo");
        print(languages);
        languages.replace("python", "replaced value");
        print(languages);
        System.out.println(languages.replace("scala","this will not be added"));


    }
    private static void print(Map<String, String> languages){

        System.out.println("-------------------------------------------------------------------");

        //to loop through the map
        for (String key : languages.keySet()){
            System.out.println(key + " : " + languages.get(key));
        }
    }
}
