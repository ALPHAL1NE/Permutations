import java.util.List;
import java.util.Scanner;

public class PermutationApp {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            PermutationCalculator calc = new PermutationCalculator();
            int choice;
            do {
                System.out.println("""
        
                ====== PERMUTATION MENU ======
                1. Show all Linear Permutations
                2. Show number of Linear and Circular Permutations
                3. About (Explanation)
                4. Exit
                """);
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {

                    case 1:
                        System.out.print("\nEnter a string (e.g., ABC): ");
                        String str = sc.nextLine();
                        List<String> perms = calc.getLinearPermutations(str);
                        perms.forEach(System.out::println);
                        System.out.println("Total: " + calc.getLinearPermutationCount(str.length()));
                        break;

                    case 2:
                        System.out.print("\nEnter number of elements (n): ");
                        int n = sc.nextInt();
                        System.out.println("\nTotal Linear Permutations (n!) = " + calc.getLinearPermutationCount(n));
                        System.out.println("Total Circular Permutations ((n - 1)!) = " + calc.getCircularPermutationCount(n));
                        break;

                    case 3:
                        System.out.println("""
                            \n=== ABOUT PERMUTATIONS ==="
                        Linear Permutation (n!): Arrangement in a straight line.
                        Circular Permutation ((n - 1)!): Arrangement around a circle.""");
                        break;

                    case 4:
                        System.out.println("\nExiting program... Goodbye!");
                        break;
                    default:
                        System.out.println("\nInvalid choice! Please try again.");
                }
                
            } while (choice != 4);
        }
    }
}