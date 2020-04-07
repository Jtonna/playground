package com.jtonna;

import java.util.ArrayList;

public class Main
{

    public static void main(String[] args)
    {
        // Create new horses from Interfaces
        Horse seabiscuit = new Horse("Seabiscuit");
        Horse affirmed = new Horse("Affirmed");
        Horse joe = new Horse("Joe");

        // We need them to 'eat' to give them 'fuel' to move
        seabiscuit.eat(10);
        affirmed.eat(25);
        joe.eat(239);

        // Move using a loop
        for (int i = 0; i < 3; i++)
        {
            seabiscuit.move();
        };
        System.out.println("Seabiscuit's fuel level after moving: " + seabiscuit.getFuelLevel() );
        System.out.println();

        // Now lets make a Horse from an Abstract Class
        System.out.println("*** adding Horses from Abstract Class");
        HorseFromVehicle secretatiat = new HorseFromVehicle("Secretatiat", 10);
        HorseFromVehicle trigger = new HorseFromVehicle("Trigger", 10);
        HorseFromVehicle seattleSlew = new HorseFromVehicle("Seattle Slew", 10);
        HorseFromVehicle americanPharoah = new HorseFromVehicle("American Pharoah", 10);
        HorseFromVehicle eclipse = new HorseFromVehicle("Eclipse");

        // Do things
        secretatiat.addFuel(10);
        eclipse.move(10);

        // Create Auto's (cars)
        System.out.println("*** adding Autos from Abstract Class");
        Auto bugatti = new Auto(24,"bugatti", 2020);
        Auto vw = new Auto(5, "Euro Van", 2000);
        Auto toyota = new Auto(10, "Tundra", 1998);

        // do things
        bugatti.move(12);
        vw.move(2);
        toyota.addFuel(354);
        toyota.move(254);

        ArrayList<AbstractVehicle> myList = new ArrayList<AbstractVehicle>();
        myList.add(bugatti);
        myList.add(vw);
        myList.add(secretatiat);
        myList.add(trigger);
        myList.add(americanPharoah);

        System.out.println("Array list from abstract class: " + myList);
    }
}