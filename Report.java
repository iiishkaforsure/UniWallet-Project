import java.util.ArrayList;

public class Report {
    
    public void showSummary(ArrayList<Expense> list) {
        if (list.isEmpty()) {
            System.out.println("No expenses to show.");
            return;
        }

        double total = 0;
        System.out.println("\n--- SPENDING REPORT ---");
        for (Expense e : list) {
            System.out.println(e.toString());
            total += e.amount;
        }
        System.out.println("-----------------------");
        System.out.println("TOTAL SPENT: Rs. " + total);

        // Simple logic for warning
        if (total > 5000) {
            System.out.println("ALERT: You are over budget!");
        }
    }
}