package GoldmanSachs;

import java.util.LinkedList;
import java.util.Queue;

public class MapOfHighestPeak {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int dirs[][] = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        int mat[][] = new int[m][n];

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    mat[i][j] = 0;
                    q.offer(new int[] { i, j });
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            int curr[] = q.poll();
            for (int dir[] : dirs) {
                int x = dir[0] + curr[0];
                int y = dir[1] + curr[1];
                if (x < 0 || y < 0 || x >= m || y >= n || mat[x][y] != -1)
                    continue;
                mat[x][y] = mat[curr[0]][curr[1]] + 1;
                q.offer(new int[] { x, y });
            }
        }

        return mat;
    }
}
