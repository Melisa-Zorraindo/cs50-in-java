import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.*;

public class CreditCardValidator {
    private final String cardType;

    public CreditCardValidator() { this.cardType = determineCardType(); }

    private String getCardNumber() {
        // Prompt user for credit card number
        String prompt = "Please enter your card number without spaces or hyphens.";
        System.out.println(prompt);

        try(Scanner inputCard = new Scanner(System.in)) {
            String cardNumber;
            String regex = "\\d+";
            Pattern p = Pattern.compile(regex);

            // Re-prompt if entered number contains letters, symbols, or spaces
            while(true) {
                cardNumber = inputCard.nextLine().trim();
                Matcher m = p.matcher(cardNumber);

                if (m.matches()) {
                    break;
                } else {
                    System.out.println("Invalid input. " + prompt);
                }
            }

            return cardNumber;
        }
    }

    private boolean isValidCardNumber(String cardNumber) {
        // Convert string received into an array of integers
        String[] digits = cardNumber.split("");

        // Reverse array
        Collections.reverse(Arrays.asList(digits));

        int odds = 0;
        int evens = 0;
        for (int i = 0; i < digits.length; i++) {
            // Multiply every odd place in the array by two
            int digit = Integer.parseInt(digits[i]);
            if(i % 2 != 0) {
                int doubled = digit * 2;
                if(doubled >= 10) {
                    // Split double digits and add them to evens
                    evens += doubled / 10 + doubled % 10;
                } else {
                    // Add digit to even
                    evens += doubled;
                }
            } else {
                // Add each digit together
                odds += digit;
            }
        }

        // Add odds and evens together
        int sum = evens + odds;
        return sum % 10 == 0;
    }

    private String determineCardType() {
        String cardNumber = getCardNumber();
        // Return AMEX, VISA, or MASTERCARD appropriately if the final product ends in 0
        if(isValidCardNumber(cardNumber)) {
            if(cardNumber.startsWith("34") || cardNumber.startsWith("37")) {
                return "AMEX";
            } else if (cardNumber.startsWith("51") || cardNumber.startsWith("52") || cardNumber.startsWith("53") || cardNumber.startsWith("54") || cardNumber.startsWith("55")) {
                return "MASTERCARD";
            } else if (cardNumber.startsWith("4")) {
                return "VISA";
            } else {
                return "UNKNOWN";
            }
        } else {
            // Return INVALID if the final product doesn't end in 0
            return "INVALID";
        }
    }

    public String getCardType() {
        return this.cardType;
    }
}
