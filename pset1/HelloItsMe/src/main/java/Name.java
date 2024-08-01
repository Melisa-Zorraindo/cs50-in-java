import java.util.Scanner;

public class Name {
    private final String name;

    public Name() {
        this.name = promptForName();
    }

    private String promptForName() {
        System.out.print("Greetings! What's your name?\n");
        try (Scanner in = new Scanner(System.in)) {
            String inputName = in.nextLine();
            while(inputName.isEmpty()) {
                System.out.print("Sorry, I didn't catch that. What's your name?\n");
                inputName = in.nextLine();
            }
            return inputName;
        }
    }

    public String getName() {
        return this.name;
    }
}
