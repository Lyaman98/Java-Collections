package com.example.collections.Collection;

import java.util.*;

public class Theatre {

    private final String theatreName;

    private List <Seat> seats = new ArrayList<>();

    static final Comparator<Seat> PRICE_ORDER = (seat1, seat2) -> {
        if (seat1.getPrice() < seat2.getPrice()){
            return -1;
        }else if(seat1.getPrice() > seat2.getPrice()){
            return 1;
        }else {
            return 0;
        }
    };

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;
        int lastRow = 'A' + (numRows - 1);

        for (char row = 'A'; row <= lastRow; row++){
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++){
                double price = 12.00;

                if ((row < 'D') && seatNum>=4 && seatNum <= 9){
                    price = 14.00;
                }else {
                    price = 7.00;
                }
                Seat seat = new Seat(row + String.format("%02d",seatNum), price);
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber){
        Seat requestedSeat = new Seat(seatNumber);

        //returns index of the element,if is found
        int foundSeat = Collections.binarySearch(seats,requestedSeat,null);
        if (foundSeat >= 0){
            return seats.get(foundSeat).reserve();
        }
        System.out.println("There is no seat " + seatNumber );
        return false;

    }

    public Collection<Seat>  getSeats(){
        return seats;
    }
    public class Seat implements Comparable<Seat> {

        private final String seatNumber;
        private boolean reserved;
        private  double price;

        public Seat(String seatNumber){
            this.seatNumber = seatNumber;
        }
        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        @Override
        public int compareTo(Seat seat) {
            //will return 0 if both strings are equal
            //if the first string is lexicographically greater than the second string else the result would be negative.
            //else will return positive
            return this.seatNumber.compareToIgnoreCase( seat.seatNumber);
        }

        public boolean reserve(){
            if(!this.reserved){
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            }
            return false;
        }

        public boolean cancel(){
            if (this.reserved){
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " is cancelled");
                return true;
            }
            return false;
        }

        public double getPrice() {
            return price;
        }


        public String getSeatNumber() {
            return seatNumber;
        }
    }
}
