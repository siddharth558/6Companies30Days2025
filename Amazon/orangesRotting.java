import java.util.LinkedList;
import java.util.Queue;

public class orangesRotting {
    class Triplet {
        int r;
        int c;
        int t;

        public Triplet(int m, int n, int time) {
            this.r = m;
            this.c = n;
            this.t = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Triplet> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Triplet(i, j, 0));
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int time = 0;

        while (!queue.isEmpty()) {
            Triplet current = queue.poll();
            int dx[] = { 0, 0, 1, -1 };
            int dy[] = { 1, -1, 0, 0 };

            for (int k = 0; k < 4; k++) {
                int newx = current.r + dx[k];
                int newy = current.c + dy[k];

                if (newx >= 0 && newx < m && newy >= 0 && newy < n && grid[newx][newy] == 1) {
                    grid[newx][newy] = 2;
                    fresh--;
                    queue.add(new Triplet(newx, newy, current.t + 1));
                    time = current.t + 1;
                }
            }
        }

        return fresh == 0 ? time : -1;
    }
}
