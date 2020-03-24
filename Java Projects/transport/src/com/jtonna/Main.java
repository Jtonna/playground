package com.jtonna;

public class Main
{

    public static void main(String[] args)
    {
        // write your code here

        // Create new horses
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

    }
}
