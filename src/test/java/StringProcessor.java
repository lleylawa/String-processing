public class StringProcessor {

    public static void main(String[] args) {
        Main processor = new Main();

        // Test cases for isStrongPassword
        System.out.println("isStrongPassword Tests:");
        System.out.println(processor.isStrongPassword("Qwerty@1234")); // true
        System.out.println(processor.isStrongPassword("abcd1234")); // false
        System.out.println(processor.isStrongPassword("QWERTY1234!")); // false
        System.out.println(processor.isStrongPassword("Abc!2345")); // true
        System.out.println(processor.isStrongPassword("Weak1!")); // false

        // Test cases for calculateDigits
        System.out.println("\ncalculateDigits Tests:");
        System.out.println(processor.calculateDigits("Hello123World456")); // 6
        System.out.println(processor.calculateDigits("NoDigitsHere!")); // 0
        System.out.println(processor.calculateDigits("1234567890")); // 10
        System.out.println(processor.calculateDigits("Mixed123Characters456")); // 6
        System.out.println(processor.calculateDigits("")); // 0

        // Test cases for calculateWords
        System.out.println("\ncalculateWords Tests:");
        System.out.println(processor.calculateWords("This is a test sentence.")); // 5
        System.out.println(processor.calculateWords("    Leading and trailing spaces    ")); // 4
        System.out.println(processor.calculateWords("SingleWord")); // 1
        System.out.println(processor.calculateWords("")); // 0
        System.out.println(processor.calculateWords("Multiple   spaces between words.")); // 5

        // Test cases for calculateExpression
        System.out.println("\ncalculateExpression Tests:");
        System.out.println(processor.calculateExpression("3 + 5")); // 8.0
        System.out.println(processor.calculateExpression("10 + 2 * 6")); // 22.0
        System.out.println(processor.calculateExpression("100 * ( 2 + 12 ) / 14")); // 100.0
        System.out.println(processor.calculateExpression("3.5 + 2.5 * 2")); // 8.5
        System.out.println(processor.calculateExpression("( 10 + 20 ) * 3 / 2")); // 45.0
    }
}
