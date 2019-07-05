package com.example.collections.SetExample;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    private static Map<String,HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {

        HeavenlyBody temp = new HeavenlyBody("Mercury",88);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        temp = new HeavenlyBody("Venus",225);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        temp = new HeavenlyBody("Earth",365);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new HeavenlyBody("Moon", 27);
        solarSystem.put(tempMoon.getName(),tempMoon);
        temp.addMoon(tempMoon);

        temp = new HeavenlyBody("Jupiter", 12);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Europa", 31);
        solarSystem.put(tempMoon.getName(),tempMoon);
        temp.addMoon(tempMoon);

        tempMoon = new HeavenlyBody("Callisto", 31);
        solarSystem.put(tempMoon.getName(),tempMoon);
        temp.addMoon(tempMoon);


        //getting all moons of Jupiter
        HeavenlyBody body = solarSystem.get("Jupiter");
        System.out.println("Moons of " + body.getName());
        for (HeavenlyBody heavenlyBody : body.getSatellites()){
            System.out.println("\t" + heavenlyBody.getName());
        }

        //creating set for all moons
        Set<HeavenlyBody> moons = new HashSet<>();
        for (HeavenlyBody planet : planets){
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All moons");
        for (HeavenlyBody moon : moons){
            System.out.println("\t" + moon.getName());
        }

        //-------------------------------------------

        //Creating a new object with the same value but different orbitalPeriod
        HeavenlyBody venus = new HeavenlyBody("Venus",123);
        //without overriding "equals" method , two objects with the same value will be created
        //the references will be compared
        planets.add(venus);

        //String class has different implementation of equals method :
        "example".equals("");


        System.out.println("Planets");
        for (HeavenlyBody planet : planets){
            System.out.println("\t" + planet.getName() + " " + planet.getOrbitalPeriod());
        }


    }
}
