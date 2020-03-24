package com.jtonna;

// The neat thing about abstract classes compared to interfaces is that abstract classes allow us to create "child" classes
// Those child classes "extend" this one. They automatically have access to all of this classes methods too
// This means we dont need to use @override methods like we do in Vehicle and Animal.
public abstract class AbstractVehicle
{
    private int fuel;

    public AbstractVehicle(int fuel)
    {
        this.fuel = fuel;
    }

    public AbstractVehicle()
    {
        fuel = 1;
    }

    public abstract String getPath(); // This class does NOT know what String getPath() is, only the class the extends AbstractVehicle does.
    public abstract String getName(); // That means these methods REQUIRE an @override to be used.

    public void move()
    {
        fuel--;
    }

    public void move(int steps)
    {
        fuel = fuel - steps;
    }

    public int getFuelLevel()
    {
        return fuel;
    }

    public void addFuel(int i)
    {
        fuel = fuel + i;
    }

}
