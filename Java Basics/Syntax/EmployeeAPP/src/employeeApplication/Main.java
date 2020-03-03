package employeeApplication; // Should ALWAYS be the same as the parent directory name

// Class is public so any other ".java" file can see/interact with it | "Main" has to match the file name
public class Main
{

    // private so only the main class can call it
    private static void workWithData()
    {
        // TODO
    }

    // Every java program has a PSVM in the "main" class, its the main method (function) that basically gets called when the program runs (after compilcaiton)
    public static void main(String[] args)
    {
        // All this is going to do is call a method, which is basically a function from JavaScript
        workWithData();
    }
}