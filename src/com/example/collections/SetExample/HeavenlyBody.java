package com.example.collections.SetExample;

import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody {

    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addMoon(HeavenlyBody moon){
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    @Override
    public int hashCode() {
        //getting the hashcode of String
        return this.name.hashCode() + 57;
    }

    @Override
    public boolean equals(Object obj) {

        //to check if references are the same
        if (this == obj){
            return true;
        }

        System.out.println("obj.getClass() is " + obj.getClass());
        System.out.println("this.getClass() is " + this.getClass());

        //check if objects are instances of the same class
        if (obj.getClass() != this.getClass()){
            return false;
        }

        if(obj instanceof HeavenlyBody){
            String objectName = ((HeavenlyBody)obj).getName();
            return this.getName().equals(objectName);

        }

        return false;

    }


}
