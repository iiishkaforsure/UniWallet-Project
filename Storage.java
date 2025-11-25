import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    // The file where data is saved
    private final String FILE_NAME = "database.txt";

    // SAVE data to file
    public void saveData(ArrayList<Expense> list) {
        try {
            FileWriter fw = new FileWriter(FILE_NAME);
            for (Expense e : list) {
                fw.write(e.toCSV() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error: Could not save data.");
        }
    }

    // LOAD data from file
    public ArrayList<Expense> loadData() {
        ArrayList<Expense> data = new ArrayList<>();
        File f = new File(FILE_NAME);
        if (!f.exists()) return data; // If no file, return empty list

        try {
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(",");
                // Basic validation to avoid crash
                if (parts.length == 3) {
                    data.add(new Expense(parts[1], Double.parseDouble(parts[2]), parts[0]));
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Error loading file.");
        }
        return data;
    }
}