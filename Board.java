import java.util.*;

public class Board {
    private int size;
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;

    public Board(int size) {
        this.size = size;
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
    }

    public int getSize() {
        return size;
    }

    public void addSnakesAndLadders(int n) {
        Random rand = new Random();

        // Add snakes
        while (snakes.size() < n) {
            int head = rand.nextInt(size * size - 1) + 2;
            int tail = rand.nextInt(head - 1) + 1;

            if (!snakes.containsKey(head))
                snakes.put(head, tail);
        }

        // Add ladders
        while (ladders.size() < n) {
            int start = rand.nextInt(size * size - 1) + 1;
            int end = rand.nextInt(size * size - start) + start + 1;

            if (!ladders.containsKey(start))
                ladders.put(start, end);
        }
    }

    public int getNextPosition(int position) {
        if (snakes.containsKey(position)) {
            System.out.println("Bitten by snake");
            return snakes.get(position);
        }
        if (ladders.containsKey(position)) {
            System.out.println("Climbed ladder");
            return ladders.get(position);
        }
        return position;
    }
}