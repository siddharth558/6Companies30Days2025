import java.util.LinkedList;
import java.util.Queue;

public class Winner {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        int winner = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < k; j++) {
                queue.offer(queue.poll());
            }
            winner = queue.poll();
        }

        return winner;
    }
}
