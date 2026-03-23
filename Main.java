import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter board size (n): ");
        int n = sc.nextInt();

        System.out.print("Enter number of players: ");
        int players = sc.nextInt();

        System.out.print("Enter difficulty (easy/hard): ");
        String levelInput = sc.next();

        GameLevel level = levelInput.equalsIgnoreCase("easy") ? GameLevel.EASY : GameLevel.HARD;

        Game game = new Game(n, players, level);
        game.startGame();
    }
}