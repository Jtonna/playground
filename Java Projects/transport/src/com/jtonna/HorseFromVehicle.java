package com.jtonna;

public class HorseFromVehicle extends AbstractVehicle
{
    public String name;

    public HorseFromVehicle(String name, int fuel)
    {
        super(fuel);
        this.fuel *= 2;
        this.name = name;
    }

    public HorseFromVehicle(String name)
    {
        super(1);
        this.name = name;
    }

    // These are the only two things the Abstract Vehicle doesnt know, so we have to have an override
    @Override
    public String getPath()
    {
        return "Dirt Road";
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return "HorseFromVehicle{" +
                "name='" + name + '\'' +
                ", fuel=" + fuel +
                '}';
    }
}
