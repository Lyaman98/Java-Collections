package com.example.junit;

public class Utilities {

    public String removePairs(String source){

        if (source.length() < 2){
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < source.length() - 1; i++){

            if (source.charAt(i) != source.charAt(i+1)){
                stringBuilder.append(source.charAt(i));
            }
        }

        stringBuilder.append(source.charAt(source.length() - 1));
        return stringBuilder.toString();
    }

    public boolean isEven(int number){
        if (number % 2 == 0){
            return true;
        }
        return false;
    }
}
