package employeeApplication; // Should ALWAYS be the same as the parent directory name

// Class is public so any other ".java" file can see/interact with it | "Main" has to match the file name
public class Main
{

    // private so only the main class can call it
    private static void workWithData()
    {
        // Instantiate (create) a new Object based on the type listed in HealthPlan.java
        // Creates a healthplan with the variable h1 which is named "Healthplan #1"
        HealthPlan h1 = new HealthPlan("Healthplan #1");
        HealthPlan h2 = new HealthPlan("Healthplan #2");
        HealthPlan h3 = new HealthPlan("Healthplan #3");

        // Create a company with the following fields
        // Company Name, Debt
        Company c1 = new Company("Jtonnas Studio", 23542);
        Company c2 = new Company("Ruben Ponce's god tier development", 3425);
        Company c3 = new Company("Lambdaaaaa", -586324);

        // Create individual employees that work at companies & that have health plans
        // fname, lname, salary, has401K, companyId, healthPlanId
        // boolean is a default class, so we have to do boolean.<true or false>
        // since Company's id is public, we can access it without a getter (this is how it used to be done and is poor programming)
        // unlike Company's id, HealthPlan is done properly, so we can get the id using the getter method. (This is the prefered way of doing it)
        Employee emp1 = new Employee("Jacob", "Tonna", 76000, Boolean.FALSE, c1.id, h1.getId());
        Employee emp2 = new Employee("Ruben", "Ponce", 90374, Boolean.TRUE, c2.id, h3.getId());
        Employee emp3 = new Employee("Daquan", "Delerose", 424256, Boolean.TRUE, c3.id, h2.getId());
        Employee emp4 = new Employee("Austen", "Prowers", 10000000, Boolean.FALSE, c3.id, h1.getId());

        // start with practice here
        // First practice round
        System.out.println("*** Query Data");

        System.out.println(c1);
        System.out.println();
        System.out.println("Original: " + c1.debt);
        c1.debt = -c1.debt;
        System.out.println("Negative: " + c1.debt);
        System.out.println();
        c1.debt = -c1.debt;

        // second practice round
        System.out.println("Original divided 5 " + (c1.debt / 5));
        System.out.println("Original mod 2     " + (c1.debt % 2));
        System.out.println("Original divided 7 " + (c1.debt / 7));
        System.out.println("Original divided 7 " + (c1.debt / 7.0));
        System.out.println("Original divided 7 " + ((double)c1.debt / 7));
        System.out.println();
        String myStr = "100";
        System.out.println("Debt: " + myStr + c1.debt);
        System.out.println("Debt: " + Integer.parseInt(myStr) + c1.debt);


        // third practice round
        System.out.println(emp1.toString());
        System.out.println();

        System.out.println(emp3.toString());
        System.out.println();


        System.out.println("*** Emp1 gets a raise");
        emp1.setSalary(emp1.getSalary() + (emp1.getSalary() * 0.03));
        System.out.println(emp1.toString());
        System.out.println();


        System.out.println("*** 401k amount for emp3");
        System.out.println(emp3.getSalary() * c1.match401k);
        System.out.println();


        // fourth practice round
        // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html
        System.out.println("*** Company Names c1+c2");
        System.out.println("Combined");
        System.out.println(c1.name + " " + c2.name);
        System.out.println("No Vowels");
        String noVowels = c1.name.toLowerCase().replaceAll("[a,e,i,o.u]", "_");
        System.out.println(noVowels);
        System.out.println();

        String nameStr = emp1.getFullName();
        System.out.println(nameStr);
        for (int i = 0; i < nameStr.length(); i++)
        {
            System.out.print(nameStr.charAt(i) + " ");
        }
        System.out.println();

    }

    // Every java program has a PSVM in the "main" class, its the main method (function) that basically gets called when the program runs (after compilcaiton)
    public static void main(String[] args)
    {
        // All this is going to do is call a method, which is basically a function from JavaScript
        workWithData();
    }
}