import java.util.Scanner;

public class Validator {
    Scanner sc = new Scanner(System.in);

    // Ensures user types a number, not letters
    public double getValidNumber() {
        while (true) {
            try {
                String input = sc.nextLine();
                double num = Double.parseDouble(input);
                if (num < 0) {
                    System.out.println("Price cannot be negative. Try again:");
                } else {
                    return num;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number (e.g. 150):");
            }
        }
    }
}