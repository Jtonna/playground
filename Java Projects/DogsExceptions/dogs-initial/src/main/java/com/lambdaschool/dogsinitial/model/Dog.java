package com.lambdaschool.dogsinitial.model;

import java.util.concurrent.atomic.AtomicLong;

public class Dog
{
    private static final AtomicLong counter = new AtomicLong();
    private long id;
    private String breed;
    private int weight;
    private boolean apartmentSuitable;

    public Dog(String breed, int weight, boolean apartmentSuitable)
    {
        this.id = counter.incrementAndGet();
        this.breed = breed;
        this.weight = weight;
        this.apartmentSuitable = apartmentSuitable;
    }

    public Dog(Dog toClone)
    {
        this.id = toClone.getId();
        this.breed = toClone.getBreed();
        this.weight = toClone.weight;
        this.apartmentSuitable = toClone.isApartmentSuitable();
    }

    public long getId()
    {
        return id;
    }

    public String getBreed()
    {
        return breed;
    }

    public void setBreed(String breed)
    {
        this.breed = breed;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    public boolean isApartmentSuitable()
    {
        return apartmentSuitable;
    }

    public void setApartmentSuitable(boolean apartmentSuitable)
    {
        this.apartmentSuitable = apartmentSuitable;
    }
}