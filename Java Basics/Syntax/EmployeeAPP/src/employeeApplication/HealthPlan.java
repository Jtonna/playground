package employeeApplication;

public class HealthPlan
{
    // fields
    private static int maxId = 0;
    private int id;
    private String name;

    // construtor
    public Healthplan(String name)
    {
        // Set data
        maxId++; // Increment maxId by 1
        id = maxId; // set the id to the incremented maxId
        this.name = name;
    }

    // getters
    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }
}