import java.util.*;

public class Game {
    private Board board;
    private Queue<Player> players;
    private Dice dice;

    public Game(int size, int numPlayers, GameLevel level) {
        this.board = new Board(size);
        this.dice = new Dice();
        this.players = new LinkedList<>();

        for (int i = 1; i <= numPlayers; i++) {
            players.add(new Player("Player " + i));
        }

        int elements = (level == GameLevel.EASY) ? size / 2 : size;
        board.addSnakesAndLadders(elements);
    }

    public void startGame() {
        int winningPosition = board.getSize() * board.getSize();

        while (players.size() > 1) {
            Player current = players.poll();

            int roll = dice.roll();
            System.out.println(current.getName() + " rolled: " + roll);

            int newPosition = current.getPosition() + roll;

            if (newPosition > winningPosition) {
                players.offer(current);
                continue;
            }

            newPosition = board.getNextPosition(newPosition);
            current.setPosition(newPosition);

            System.out.println(current.getName() + " moved to: " + newPosition);

            if (newPosition == winningPosition) {
                System.out.println(current.getName() + " WON!");
            } else {
                players.offer(current);
            }
        }

        System.out.println("Game over!");
    }
}