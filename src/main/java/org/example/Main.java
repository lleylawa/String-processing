package org.example;

public class Main {
    public static void main(String[] args) {
        StringProcessor processor = new StringProcessor();

        System.out.println(processor.isStrongPassword("Qwerty@1234")); // true
        System.out.println(processor.isStrongPassword("abcd1234")); // false
        System.out.println(processor.calculateDigits("Hello123World456")); // 6
        System.out.println(processor.calculateWords("This is a test sentence.")); // 5
        System.out.println(processor.calculateExpression("( 10 + 20 ) * 3 / 2")); // 45.0
    }

}
