import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Storage storage = new Storage();
        Report report = new Report();
        Validator val = new Validator();
        
        ArrayList<Expense> expenses = storage.loadData(); // Load old data

        System.out.println("=== UNIWALLET: STUDENT TRACKER ===");

        while (true) {
            System.out.println("\n1. Add Expense");
            System.out.println("2. View Report");
            System.out.println("3. Save & Exit");
            System.out.print("Select Option: ");
            
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                System.out.print("Enter Date (e.g., 25-Nov): ");
                String date = sc.nextLine();
                System.out.print("Enter Category (Food/Travel): ");
                String cat = sc.nextLine();
                System.out.print("Enter Amount: ");
                double amount = val.getValidNumber(); // uses Validator
                
                expenses.add(new Expense(cat, amount, date));
                System.out.println("Saved!");

            } else if (choice.equals("2")) {
                report.showSummary(expenses);

            } else if (choice.equals("3")) {
                storage.saveData(expenses);
                System.out.println("Data Saved. Goodbye!");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }
}