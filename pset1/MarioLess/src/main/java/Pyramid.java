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
        }
        return pyramidBuilder.toString();
    }

    private String generateBlanks(int blanks) {
        StringBuilder blanksBuilder = new StringBuilder();
        for (int i = blanks; i > 0; i--) {
            blanksBuilder.append(" ");
        }
        return blanksBuilder.toString();
    }

    private String generateBricks(int bricks) {
        StringBuilder bricksBuilder = new StringBuilder();
        for (int i = 0; i < bricks; i++) {
            bricksBuilder.append("#");
        }
        bricksBuilder.append("\n");
        return bricksBuilder.toString();
    }

    public String getPyramid() {
        System.out.println("Printing your pyramid...");
        return this.pyramid;
    }
}
