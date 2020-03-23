package employeeApplication; // name of the package

public class Company
{
    // Fields
    private static int maxId = 0;
    public final static double match401k = 0.05; // Final is basically a const in javascript, meaning it cant be changed & Static means all objects share it

    public int id;
    public String name;
    public int debt;

    // Constructor
    public Company(String name, int debt)
    {
        this.id = maxId++;
        this.name = name;
        this.debt = debt;
    }

    // no getters or setters
}
