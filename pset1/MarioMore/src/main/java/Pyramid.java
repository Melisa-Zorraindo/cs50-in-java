import java.util.Scanner;

public class Pyramid {
    private final String pyramid;

    public Pyramid() {
        this.pyramid = buildPyramid();
    }

    private int promptForHeight() {
        System.out.print("Greetings! How tall do you want your pyramid to be?\n");
        try (Scanner inputHeight = new Scanner(System.in)) {
            int height = 0;
            boolean validInput = false;

            while (!validInput) {
                String input = inputHeight.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Please enter a value.");
                } else {
                    try {
                        height = Integer.parseInt(input);
                        if (height >= 1 && height <= 8) {
                            validInput = true;
                        } else {
                            System.out.println("Please enter a number between one and eight.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter an integer between one and eight.");
                    }
                }
            }
            return height;
        }
    }

    private String buildPyramid() {
        int h = promptForHeight();
        StringBuilder pyramidBuilder = new StringBuilder();

        for (int i = 0; i < h; i++) {
            pyramidBuilder.append(generateBlanks(h - i - 1));
            pyramidBuilder.append(generateBricks(i + 1) );
            pyramidBuilder.append(generateBlanks(2));
            pyramidBuilder.append(generateBricks(i + 1) );
            pyramidBuilder.append("\n");
        }
        return pyramidBuilder.toString();
    }

    private String generateBlanks(int blanks) {
        return " ".repeat(Math.max(0, blanks));
    }

    private String generateBricks(int bricks) {
        return "#".repeat(Math.max(0, bricks));
    }

    public String getPyramid() {
        return this.pyramid;
    }
}
