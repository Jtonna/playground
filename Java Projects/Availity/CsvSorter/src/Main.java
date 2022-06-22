import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Main {

    Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args)
    {
        Main obj = new Main();
        obj.GroupEnrolleesByInsurance();

    }

    /**
     * Reads a .csv file of enrollees, groups them by insurance companies, and
     * creates dedicated .csv files of the most recent enrollees within those
     * insurance companies.
     * Enrollees in each file are sorted by last name then first name in ascending
     * order with duplicates removed.
    */

     public void GroupEnrolleesByInsurance() {
         try (BufferedReader reader = new BufferedReader(
                 new FileReader(String.format("%s/testdata.csv", System.getProperty("user.dir")))
              ))
         {
             HashMap<String, HashMap<String, Enrollee>> enrolleesByInsurance = new HashMap<String, HashMap<String, Enrollee>>();
             String newLine = "";

             // Read the file line by line
             while ((newLine = reader.readLine()) != null) {
                 String[] lineValues = newLine.split(",");

                 // Filter out the header line
                 if (lineValues[0].equalsIgnoreCase("id"))
                 {
                     continue;
                 }

                int version = 0;
                try {
                    version = Integer.parseInt(lineValues[3]);
                } catch (NumberFormatException nFormatException) {
                    System.out.println("Version is not a valid number. Skipping row.");
                    nFormatException.printStackTrace();
                    continue;
                }

                // Create a new map of enrollees
                Enrollee enrollee = new Enrollee(lineValues[0], lineValues[1], lineValues[2], version, lineValues[4]);

                // Check the hashmap of enrollees for existing entries
                if (enrolleesByInsurance.containsKey(lineValues[4])) {
                    HashMap<String, Enrollee> mapEnrollees = enrolleesByInsurance.get(lineValues[4]);
                    Enrollee existing = mapEnrollees.get(enrollee.userId);

                    // If enrollee does not exist, add them to the collection
                    if (existing == null) {
                        mapEnrollees.put(enrollee.userId, enrollee);
                        continue;
                    }

                    // If we find a more recent version of an enrollee, use that instead
                    if (existing.version < enrollee.version) {
                        mapEnrollees.replace(lineValues[0], enrollee);
                    }

                } else {
                    // Add new insurance and new map of enrollees
                    HashMap<String, Enrollee> map = new HashMap<String, Enrollee>();
                    map.put(enrollee.userId, enrollee);
                    enrolleesByInsurance.put(lineValues[4], map);
                }
             }

             // Iterate through the hashmap of enrollees and write out the files
             for (Map.Entry<String, HashMap<String, Enrollee>> e : enrolleesByInsurance.entrySet())
             {
                 String key = e.getKey();
                 Enrollee[] list = e.getValue()
                         .values()
                         .stream()
                         .sorted(Comparator.comparing(x -> x.firstName))
                         .sorted(Comparator.comparing(x -> x.lastName))
                         .toArray(Enrollee[]::new);

                 String fileName = String.format("results/%s_Enrollees.csv", key);
                 LOGGER.info(String.format("Writing file: %s", fileName));
                 FileWriter fileWriter = new FileWriter(fileName, false);
                 fileWriter.write("");
                 fileWriter.close();

                 try (PrintWriter writer = new PrintWriter(fileName)) {
                     StringBuilder sb = new StringBuilder();
                     for (Enrollee enrollee : list) {
                         sb.append(enrollee.userId);
                         sb.append(',');
                         sb.append(enrollee.firstName);
                         sb.append(',');
                         sb.append(enrollee.lastName);
                         sb.append(',');
                         sb.append(enrollee.version);
                         sb.append(',');
                         sb.append(enrollee.insuranceCompany);
                         sb.append('\n');
                     }

                     writer.write(sb.toString());

                 } catch (Exception ex) {
                     ex.printStackTrace();
                 }
             }

         } catch (FileNotFoundException fnfException) {
             LOGGER.severe("File was not found");
             fnfException.printStackTrace();
         } catch (IOException ioException) {
             LOGGER.severe("I/O exception occured");
             ioException.printStackTrace();
         }
     }
}