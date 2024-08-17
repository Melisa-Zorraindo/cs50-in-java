import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Scrabble {
    private final Scanner inputWord = new Scanner(System.in);

    private String getWord(int playerNumber) {
        String prompt = String.format("Player %s:", playerNumber);
        System.out.println(prompt);

        String word;
        String regex = "[a-zA-Z]+";
        Pattern p = Pattern.compile(regex);

        // Re-prompt if entered word contains numbers, symbols, or spaces
        while(true) {
            word = inputWord.nextLine().trim();
            Matcher m = p.matcher(word);

            if (m.matches()) {
                break;
            } else {
                System.out.println("Please enter a word without numbers or symbols.\n" + prompt);
            }
        }

        return word;
    }

    private int calculateScore(String word) {
        int score = 0;

        for (int i = 0; i < word.length(); i++) {
                score += ScoreSystem.getScoreForLetter(word.toLowerCase().charAt(i));
        }
        return score;
    }

    public int getWinner() {
        // prompt players for word
        String wordOne = getWord(1);
        String wordTwo = getWord(2);

        // calculate word score
        int scorePlayerOne = calculateScore(wordOne);
        int scorePlayerTwo = calculateScore(wordTwo);

        // return winner:
        if (scorePlayerOne > scorePlayerTwo) {
            // 1: for Player one
            return 1;
        } else if (scorePlayerTwo > scorePlayerOne) {
            // 2: for Player two
            return 2;
        } else {
            // 0: for tie
            return 0;
        }
    }

    public void close() {
        inputWord.close();
    }
}