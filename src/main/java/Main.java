import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    // Checks if the provided password is strong
    public boolean isStrongPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUppercase = false, hasLowercase = false, hasDigit = false, hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecial = true;
            }
        }

        return hasUppercase && hasLowercase && hasDigit && hasSpecial;
    }

    // Counts the number of digits in a given file
    public int calculateDigitsFromFile(String filePath) {
        File file = new File(filePath);
        int count = 0;

        try (Scanner scanner = new Scanner(file)) {
            // Read the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                count += calculateDigits(line);
            }
        } catch (IOException e) {
            // Handle the exception
            System.out.println("An IOException occurred while reading the file: " + e.getMessage());
        }

        return count;
    }

    // Calculates the number of words in a given file
    public int calculateWordsFromFile(String filePath) {
        File file = new File(filePath);
        int count = 0;

        try (Scanner scanner = new Scanner(file)) {
            // Read the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                count += calculateWords(line);
            }
        } catch (IOException e) {
            // Handle the exception
            System.out.println("An IOException occurred while reading the file: " + e.getMessage());
        }

        return count;
    }

    // Counts the number of digits in the given sentence
    public int calculateDigits(String sentence) {
        if (sentence == null) {
            return 0;
        }

        int count = 0;
        for (char ch : sentence.toCharArray()) {
            if (Character.isDigit(ch)) {
                count++;
            }
        }

        return count;
    }

    // Calculates the number of words in the given sentence
    public int calculateWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return 0;
        }

        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }

    // Calculates and returns the result of the expression
    public double calculateExpression(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be null or empty");
        }

        try {
            return evaluate(expression);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid expression");
        }
    }

    // Helper method to evaluate an arithmetic expression
    private double evaluate(String expression) {
        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // Skip spaces
            if (Character.isWhitespace(ch)) {
                continue;
            }

            // If the character is a digit, read the full number
            if (Character.isDigit(ch) || ch == '.') {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i++));
                }
                i--; // Adjust index after the loop
                values.push(Double.parseDouble(sb.toString()));
            }
            // If the character is an opening bracket, push it to the operators stack
            else if (ch == '(') {
                operators.push(ch);
            }
            // If the character is a closing bracket, solve the sub-expression
            else if (ch == ')') {
                while (operators.peek() != '(') {
                    values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
                }
                operators.pop();
            }
            // If the character is an operator
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!operators.isEmpty() && hasPrecedence(ch, operators.peek())) {
                    values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(ch);
            }
        }

        // Apply remaining operators to remaining values
        while (!operators.isEmpty()) {
            values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    // Method to check operator precedence
    private boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        return (op1 != '*' && op1 != '/') || (op2 != '+' && op2 != '-');
    }

    // Method to apply an operation to two operands
    private double applyOperation(char operator, double b, double a) {
        if (operator == '+') {
            return a + b;
        } else if (operator == '-') {
            return a - b;
        } else if (operator == '*') {
            return a * b;
        } else if (operator == '/') {
            if (b == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return a / b;
        }
        throw new IllegalArgumentException("Invalid operator");
    }
}
