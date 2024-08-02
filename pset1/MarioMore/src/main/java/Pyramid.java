import java.util.Scanner;

public class Pyramid {
    private final String pyramid;

    public Pyramid() {
        this.pyramid = buildPyramid();
    }

    private int promptForHeight() {
        System.out.print("Greetings! How tall do you want your pyramid to be?\n");
        try (Scanner inputHeight = new Scanner(System.in)) {
            int height;

            while(true) {
                if(inputHeight.hasNextInt()) {
                    height = inputHeight.nextInt();
                    if(height > 0) {
                        break;
                    } else {
                        System.out.println("Sorry, I cannot make that pyramid. Enter a whole number greater than zero\n");
                    }
                } else {
                    System.out.println("Please enter a number\n");
                    inputHeight.next();
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
            pyramidBuilder.append(generateBlanks(3));
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
