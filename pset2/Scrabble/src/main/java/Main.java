public class Main {
    public static void main(String[] args) {
        Scrabble game = new Scrabble();
        int winner = game.getWinner();

        switch (winner) {
            case 0:
                System.out.println("It's a tie!");
                break;
            case 1:
                System.out.println("Player 1 wins!");
                break;
            case 2:
                System.out.println("Player 2 wins!");
        }

        game.close();
    }
}
