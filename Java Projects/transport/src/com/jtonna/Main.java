package com.jtonna;

import java.util.ArrayList;

public class Main
{

    // Function that, well... prints vehicles
    public static void printVehicles(ArrayList<AbstractVehicle> vehicles, CheckVehicle tester)
    {
        for(AbstractVehicle veh : vehicles)
        {
            if(tester.test(veh))
            {
                System.out.println(veh.getName() + " " + veh.getFuelLevel());
            }
        }
    }
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
        myList.add(toyota);

        // Lambda Expressions
        System.out.println("*** Lambda Expressions");
        System.out.println("* x -> Y"); // anonymous functions basically
        System.out.println();

        // filter data lambda expressions
        System.out.println("* Vehicles in list with a fuel level > 0");
        printVehicles(myList, v -> v.getFuelLevel() > 0); // print if the fuel is level is greater than 0
        System.out.println();
        System.out.println("* Vehicles wit fuel level > 0 & are from the HorseFromVehicle class");
        printVehicles(myList, v -> (v.getFuelLevel() > 0 ) && (v instanceof HorseFromVehicle) ); // print if the fuel level is greater than 0 and is from the HorseFromVehicle class
        System.out.println();

        System.out.println("* Every item in the list using lambda expression");
        myList.forEach( (v) -> System.out.println(v) ); // Print every item in the list out
        System.out.println();

        // sort data using lambda expression (we should only sort by things that are common between all objects)
        System.out.println("* Sort the list and re-print");
        myList.sort( (v1, v2) -> v1.getName().compareToIgnoreCase(v2.getName()) ); // sort the array list
        myList.forEach( (v) -> System.out.println(v)); // print the sorted list
        System.out.println();

        // just print out the names from the sorted list
        System.out.println("* Print names from the sorted array list");
        myList.forEach( (v) -> System.out.println(v.getName()));
    }

}