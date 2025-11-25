public class Expense {
    
    String category;
    double amount;
    String date;

    public Expense(String category, double amount, String date) {
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    
    public String toCSV() {
        return date + "," + category + "," + amount;
    }

    
    public String toString() {
        return "Date: " + date + " | Cat: " + category + " | Cost: Rs." + amount;
    }
}