import java.util.Scanner;

public class Change {
    private final int change;

    public Change() {
        this.change = calculateNumberOfCoins();
    }

    private int promptForChange() {
        System.out.print("Greetings! What's the change owed in cents?\n");
        try (Scanner inputChange = new Scanner(System.in)) {
            int change = 0;
            boolean validInput = false;

            while (!validInput) {
                String input = inputChange.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Please enter a value.");
                } else {
                    try {
                        change = Integer.parseInt(input);
                        if (change >= 1) {
                            validInput = true;
                        } else {
                            System.out.println("Please enter a number greater than zero.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter an integer greater than zero.");
                    }
                }
            }
            return change;
        }
    }

    private int calculateNumberOfCoins(){
        double requestedChange = promptForChange();
        double remainder;
        int amountOfQuarters;
        int amountOfDimes;
        int amountOfNickels;
        int amountOfPennies;

        int quarter = 25;
        amountOfQuarters = (int)Math.floor(requestedChange/quarter);
        System.out.println("Amount of quarters: " + amountOfQuarters);

        remainder = requestedChange % quarter;

        int dime = 10;
        amountOfDimes = (int)Math.floor(remainder/dime);
        System.out.println("Amount of dimes: " + amountOfDimes);

        remainder -= dime * amountOfDimes;

        int nickel = 5;
        amountOfNickels = (int)Math.floor(remainder/nickel);
        System.out.println("Amount of nickels: " + amountOfNickels);

        remainder -= nickel * amountOfNickels;

        int penny = 1;
        amountOfPennies = (int)Math.floor(remainder/penny);
        System.out.println("Amount of pennies: " + amountOfPennies);

        return amountOfQuarters + amountOfDimes + amountOfNickels + amountOfPennies;
    }

    public int getChange() {
        return this.change;
    }
}
