import java.util.Scanner;

public class Readability {
    private String promptForText() {
        System.out.print("Write your text here:\n");
        try (Scanner in = new Scanner(System.in)) {
            String inputText = in.nextLine();
            while(inputText.isEmpty()) {
                System.out.print("Please, write your text:\n");
                inputText = in.nextLine();
            }
            return inputText;
        }
    }

    private int countLetters(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                count++;
            }
        }
        return count;
    }

    private int countWords(String text) {
        String[] words = text.split("\\s+");
        return words.length;
    }

    private int countSentences(String text) {
        String[] sentences = text.split("[.!?]");
        return sentences.length;
    }

    private int calculateReadabilityIndex() {
        String text = promptForText();
        int letters = countLetters(text);
        int words = countWords(text);
        int sentences = countSentences(text);

        double L = ((double) letters / words) * 100;
        double S = ((double) sentences / words) * 100;

        double index = 0.0588 * L - 0.296 * S - 15.8;

        return (int) Math.round(index);
    }

    public String getReadabilityIndex() {
        int readabilityIndex = calculateReadabilityIndex();

        if (readabilityIndex < 1) {
            return "Before Grade 1";
        } else if (readabilityIndex <= 16) {
            return "Grade: " + readabilityIndex;
        } else {
            return "Grade 16+";
        }
    }
}
