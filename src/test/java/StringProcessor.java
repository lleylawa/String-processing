import java.util.Scanner;

public class StringProcessor {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        // Example interaction with user for strong password check
        System.out.println("Enter a password to check if it is strong:");
        String password = scanner.nextLine();
        System.out.println("Is strong password: " + main.isStrongPassword(password));

        // Example of reading from a file for digit count
        System.out.println("\nEnter the path to a file to count the number of digits:");
        String filePathForDigits = scanner.nextLine();
        int digitCount = main.calculateDigitsFromFile(filePathForDigits);
        System.out.println("Number of digits in the file: " + digitCount);

        // Example of reading from a file for word count
        System.out.println("\nEnter the path to a file to count the number of words:");
        String filePathForWords = scanner.nextLine();
        int wordCount = main.calculateWordsFromFile(filePathForWords);
        System.out.println("Number of words in the file: " + wordCount);

        scanner.close();
    }
}
