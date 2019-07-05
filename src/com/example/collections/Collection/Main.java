package com.example.collections.Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Theatre theatre = new Theatre("Olympian",8,12);

        //to copy one list into another (shallow copy), but there are the same shared objects
        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.getSeats());
        printList(seatCopy);

        //reverses the order of the list
        Collections.reverse(seatCopy);
        printList(seatCopy);

        //in random order
        Collections.shuffle(seatCopy);
        printList(seatCopy);

        Theatre.Seat minSeat = Collections.min(seatCopy);
        Theatre.Seat maxSeat = Collections.max(seatCopy);
        System.out.println("Min seat number is " + minSeat.getSeatNumber());
        System.out.println("Max seat number is " + maxSeat.getSeatNumber());

        System.out.println("Sorted list ");
        sortList(seatCopy);
        printList(seatCopy);

        //-------------------------------------------------------------------

        System.out.println("Is sorted by price");

        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
        priceSeats.add(theatre.new Seat("B00", 13.00));
        priceSeats.add(theatre.new Seat("A00", 13.00));
        Collections.sort(priceSeats, Theatre.PRICE_ORDER);
        printList(priceSeats);

    }

    private static void printList(List<Theatre.Seat> seats){
        for(Theatre.Seat seat : seats){
            System.out.print(" " + seat.getSeatNumber() + " " + seat.getPrice());
        }
        System.out.println();
    }

    public static void sortList(List<? extends Theatre.Seat> list){

        //bubble sort
        for (int i = 0; i < list.size() - 1; i++){
            for (int j = i + 1; j < list.size(); j++){
                if(list.get(i).compareTo(list.get(j)) > 0){
                    Collections.swap(list,i,j);
                }
            }
        }

    }
}
