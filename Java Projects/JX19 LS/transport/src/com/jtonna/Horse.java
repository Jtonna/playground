package com.jtonna;

public class Horse implements Vehicle, Animal
{
    private int fuel = 0;
    private String name;

    // Constructor for its name
    public Horse(String name)
    {
        this.name = name;
    }

    // Get & set names
    public String getName()
    {
        return name.toUpperCase();
    }

    public void setName(String name)
    {
        this.name = name;
    }

    // Overrides for Animal Interface
    @Override
    public void eat(int i)
    {
        // Set fuel levels
        fuel = fuel + i;
    }

    @Override
    public String speak()
    {
        // What does the horse say
        return "Neigh";
    }

    // Overrides for Vehicle Interface
    @Override
    public String getPath()
    {
        return "Grass";
    }

    @Override
    public void move()
    {
        fuel = fuel - 1;
    }

    @Override
    public int getFuelLevel()
    {
        return fuel;
    }

    @Override
    public void addFuel(int i)
    {
        eat(i);
    }
}
