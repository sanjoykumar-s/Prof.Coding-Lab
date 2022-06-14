import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {

//		Check arguments
        if (args[0].equals("a")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String line = bufferedReader.readLine();
                String names[] = line.split(",");
                for (String name : names) {
                    System.out.println(name.trim());
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("r")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String line = bufferedReader.readLine();
                String names[] = line.split(",");

                int randomIndex = (int) ((Math.random() * ((names.length-1) - 0)));
                System.out.println(names[randomIndex].trim());
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter bufferedReader = new BufferedWriter(
                        new FileWriter("students.txt", true));
                String subStringToAdd = args[0].substring(1);
                Date date = new Date();
                String timeFormat = "dd/mm/yyyy-hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(timeFormat);
                String formatedDate = dateFormat.format(date);
                bufferedReader.write(", " + subStringToAdd + "\nList last updated on " + formatedDate);
                bufferedReader.close();
            } catch (Exception e) {
            }

            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String line = bufferedReader.readLine();
                String names[] = line.split(",");
                boolean done = false;
                String subStringToAdd = args[0].substring(1);
                for (int id = 0; id < names.length && !done; id++) {
                    if (names[id].trim().equals(subStringToAdd)) {
                        System.out.println("We found it!");
                        done = true;
                    }
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String line = bufferedReader.readLine();
                char alphabates[] = line.toCharArray();
                int count = 0;
                for (char space : alphabates) {
                    if (space == ' ') {
                        count++;
                    }
                }
                System.out.println(count+1 + " word(s) found ");
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else {
            System.out.println("Sorry Sir! Your Argument is wrong.\nPlease give the right argument and run the program again.");
            System.out.println("\na :for print contains.");
            System.out.println("?word :for searching the word");
            System.out.println("+word :for add words.");
            System.out.println("c :for counting space");

        }
    }
}
