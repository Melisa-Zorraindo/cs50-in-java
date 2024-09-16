import java.util.Scanner;

public class Caesar {

    // Prompt the user for a message
    public String getText(Scanner inputScanner) {
        System.out.println("Please enter the text you want to encrypt:");

        String text = inputScanner.nextLine().trim();
        while (text.isEmpty()) {
            System.out.print("Please, write your text:");
            text = inputScanner.nextLine().trim();
        }

        return text;
    }

    // Prompt the user for an encryption key
    public int getKey(Scanner inputScanner) {
        System.out.println("Please enter the encryption key: ");
        int key = 0;
        boolean validInput = false;

        while (!validInput) {
            String input = inputScanner.nextLine();
            try {
                key = Integer.parseInt(input);
                if (key >= 1) {
                    validInput = true;
                } else {
                    System.out.println("Please enter a number greater than zero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
        return key;
    }

    // Encrypt text
    public String getEncryptedText(String text, int encryptionKey) {
        char[] textToEncrypt = text.toCharArray();
        char[] encryptedCharacters = new char[textToEncrypt.length];

        // Map each character to their equivalent Ascii
        // Convert the ascii back to a character
        for (int i = 0; i < textToEncrypt.length; i++) {
            char currentChar = textToEncrypt[i];

            if (Character.isLowerCase(currentChar)) {
                int convertedChar = ((currentChar - 'a' + encryptionKey) % 26) + 'a';
                encryptedCharacters[i] = (char) convertedChar;
            } else if (Character.isUpperCase(currentChar)) {
                int convertedChar = ((currentChar - 'A' + encryptionKey) % 26) + 'A';
                encryptedCharacters[i] = (char) convertedChar;
            } else {
                // If the character is not a letter, don't encrypt it
                encryptedCharacters[i] = currentChar;
            }
        }
        return new String(encryptedCharacters);
    }
}

