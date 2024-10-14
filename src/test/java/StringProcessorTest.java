import org.example.StringProcessor;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StringProcessorTest {

    StringProcessor processor = new StringProcessor();

    @Test
    void testIsStrongPassword() {
        assertTrue(processor.isStrongPassword("Qwerty@1234"), "Should return true for a strong password.");
        assertFalse(processor.isStrongPassword("abcd1234"), "Should return false for a weak password (no uppercase, digit, or special char).");
        assertFalse(processor.isStrongPassword("QWERTY1234!"), "Should return false for no lowercase character.");
        assertTrue(processor.isStrongPassword("Abc!2345"), "Should return true for a strong password.");
        assertFalse(processor.isStrongPassword("Weak1!"), "Should return false for a short password (less than 8 characters).");
    }

    @Test
    void testCalculateDigits() {
        assertEquals(6, processor.calculateDigits("Hello123World456"), "Should count 6 digits.");
        assertEquals(0, processor.calculateDigits("NoDigitsHere!"), "Should count 0 digits.");
        assertEquals(10, processor.calculateDigits("1234567890"), "Should count 10 digits.");
        assertEquals(6, processor.calculateDigits("Mixed123Characters456"), "Should count 6 digits.");
        assertEquals(0, processor.calculateDigits(""), "Should count 0 digits.");
    }

    @Test
    void testCalculateWords() {
        assertEquals(5, processor.calculateWords("This is a test sentence."), "Should count 5 words.");
        assertEquals(4, processor.calculateWords("    Leading and trailing spaces    "), "Should count 4 words.");
        assertEquals(1, processor.calculateWords("SingleWord"), "Should count 1 word.");
        assertEquals(0, processor.calculateWords(""), "Should return 0 for empty string.");
        assertEquals(4, processor.calculateWords("Multiple   spaces between words."), "Should count 4 words.");
    }

    @Test
    void testCalculateExpression() {
        assertEquals(8.0, processor.calculateExpression("3 + 5"), 0.001, "Should return 8 for 3 + 5.");
        assertEquals(22.0, processor.calculateExpression("10 + 2 * 6"), 0.001, "Should return 22 for 10 + 2 * 6.");
        assertEquals(100.0, processor.calculateExpression("100 * ( 2 + 12 ) / 14"), 0.001, "Should return 100 for 100 * ( 2 + 12 ) / 14.");
        assertEquals(8.5, processor.calculateExpression("3.5 + 2.5 * 2"), 0.001, "Should return 8.5 for 3.5 + 2.5 * 2.");
        assertEquals(45.0, processor.calculateExpression("( 10 + 20 ) * 3 / 2"), 0.001, "Should return 45 for ( 10 + 20 ) * 3 / 2.");
    }
}
