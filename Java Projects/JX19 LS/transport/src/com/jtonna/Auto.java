package com.jtonna;

public class Auto extends AbstractVehicle
{
    public String model;
    public int year;

    // Constructor
    public Auto(int fuel, String model, int year)
    {
        super(fuel);
        this.fuel = fuel;
        this.model = model;
        this.year = year;
    }

    // Mandatory overrides
    @Override
    public String getPath()
    {
        return "Paved Roads";
    }

    @Override
    public String getName()
    {
        return model;
    }

    // for system.out
    @Override
    public String toString()
    {
        return "Auto{" + "model='" + model + '\'' + ", year=" + year + ", fuel=" + fuel + '}';
    }
}
