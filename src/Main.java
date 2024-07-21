import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<String> items = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" this my learning with simple crud and calculator methods");

        System.out.println("\n--- crud Operations ---");
        System.out.println("1. Add Item");
        System.out.println("2. View Items");
        System.out.println("3. Update Item");
        System.out.println("4. Delete Item");
        System.out.print("Choose an option (1-4): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter item to add: ");
                String newItem = scanner.nextLine();
                addItem(newItem);
                break;
            case 2:
                viewItems();
                break;
            case 3:
                System.out.print("Enter item index to update: ");
                int updateIndex = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter new item value: ");
                String updatedItem = scanner.nextLine();
                updateItem(updateIndex, updatedItem);
                break;
            case 4:
                System.out.print("Enter item index to delete: ");
                int deleteIndex = scanner.nextInt();
                deleteItem(deleteIndex);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }


        System.out.println("\n--- Calculator Operations ---");
        System.out.print("enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("enter second number: ");
        double num2 = scanner.nextDouble();
        System.out.print("enter  the operation (+, -, *, /): ");
        char operation = scanner.next().charAt(0);

        double result = performCalculation(num1, num2, operation);
        System.out.println("Result: " + result);

        scanner.close();
    }


    private static void addItem(String item) {
        items.add(item);
        System.out.println("Item added.");
    }

    private static void viewItems() {
        if (items.isEmpty()) {
            System.out.println("No items to display.");
        } else {
            for (int i = 0; i < items.size(); i++) {
                System.out.println(i + ": " + items.get(i));
            }
        }
    }

    private static void updateItem(int index, String newItem) {
        if (index >= 0 && index < items.size()) {
            items.set(index, newItem);
            System.out.println("Item updated.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    private static void deleteItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            System.out.println("Item deleted.");
        } else {
            System.out.println("Invalid index.");
        }
    }


    private static double performCalculation(double num1, double num2, char operation) {
        switch (operation) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    System.out.println("Error: Division by zero.");
                    return Double.NaN;
                }
            default:
                System.out.println("Invalid operation.");
                return Double.NaN;
        }
    }
}
