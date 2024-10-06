# StringProcessor Java Project

## Overview
This Java project consists of two classes:

1. **Main**: The main class that contains methods to process strings, such as checking password strength, counting digits and words in sentences, and evaluating arithmetic expressions.
2. **StringProcessor**: A test class that contains test cases to verify the functionality of the `Main` class.

## Features
The `Main` class contains the following methods:

1. **isStrongPassword(String password)**:
   - Checks if a given password is strong.
   - A strong password must contain at least one uppercase letter, one lowercase letter, one digit, and one special symbol.
   - Returns `true` if the password is strong; otherwise, returns `false`.

2. **calculateDigits(String sentence)**:
   - Counts the number of digits in a given sentence.
   - Returns the count of digits.

3. **calculateWords(String sentence)**:
   - Calculates the number of words in a given sentence.
   - Words are considered separated by spaces.
   - Returns the count of words.

4. **calculateExpression(String expression)**:
   - Evaluates a given arithmetic expression with numbers, operations (`+`, `-`, `*`, `/`), and parentheses.
   - Assumes that the expression is well-formed and returns the calculated result.

The `StringProcessor` class contains various test cases for each of the methods:

1. **isStrongPassword Tests**:
   - Tests with different password scenarios including valid and invalid passwords.

2. **calculateDigits Tests**:
   - Tests counting the number of digits in strings with varying amounts of digits.

3. **calculateWords Tests**:
   - Tests counting the number of words in strings with different amounts of whitespace.

4. **calculateExpression Tests**:
   - Tests evaluating arithmetic expressions, including addition, subtraction, multiplication, and division.
