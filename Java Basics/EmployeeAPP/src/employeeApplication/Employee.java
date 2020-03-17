package employeeApplication; // Name of the package

public class Employee
{
    // Fields (every employee has)
    private static int maxId = 0; // static means all of the "objects" ever created share this field, but they will have different values.
    private int id;
    private String fname;
    private String lname;
    private double salary; // real number, aka float 3.14
    private Boolean has401k; // Boolean is a class thats built in, it accepts either true or false
    private int companyID; // What company they work for
    private int healthPlanID; // How to find their health plan

    // Constructor
    // When the class is called it sets the initial value for all of the attributes specified in the constructor
    // In a nutshell this creates a new "employee" "object" and sets its "state", where the state is the initial values specified in the constructor
    // note, we dont set the "int id" because
    public Employee(String fname, String lname, double salary, Boolean has401k, int companyID, int healthPlanID)
    {
        // this Constructor sets the values passed into the class Employee, to the fields we defined above.

        // increment maxId by 1 & let the id for the current "employee" = the incremented "maxId"
        maxId++;
        id = maxId;

        // this.<something> is a field, whatever it equals is the passed in value
        this.fname = fname;
        this.lname = lname;
        this.salary = salary;
        this.has401k = has401k;
        this.companyID = companyID;
        this.healthPlanID = healthPlanID;
    }

    // getters and setters methods
    // These allow us to get values & set values
    // We can also manipulate or change values before they are set or returned to the user if we would like.
    // example of a custom getter below

    public String getFullName()
    {
        return fname + " " + lname;
        // example: "Jacob Tonna"
    }

    // Auto Generated Getters and Setters
    // NOTE: @override below

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getFname()
    {
        return fname;
    }

    public void setFname(String fname)
    {
        this.fname = fname;
    }

    public String getLname()
    {
        return lname;
    }

    public void setLname(String lname)
    {
        this.lname = lname;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    public boolean isHas401k()
    {
        return has401k;
    }

    public void setHas401k(Boolean has401k)
    {
        this.has401k = has401k;
    }

    public int getCompanyID()
    {
        return companyID;
    }

    public void setCompanyID(int companyID)
    {
        this.companyID = companyID;
    }

    public int getHealthPlanID()
    {
        return healthPlanID;
    }

    public void setHealthPlanID(int healthPlanID)
    {
        this.healthPlanID = healthPlanID;
    }

    @Override public String toString()
    {
        String rtnStr = "id: " + id + "\n" + "fname: " + fname + "\n" + "lname: " + lname + "\n" + "salary: " + salary + "\n" + "has401k: " + has401k + "\n" + "companyID: " + companyID + "\n" + "healthPlanID: " + healthPlanID + "\n";
        return rtnStr;
    }
}