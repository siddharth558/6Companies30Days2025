import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Threshold {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        int ans = -1;
        int reachable = Integer.MAX_VALUE;
        for (int i = 0; i < edges.length; i++) {
            graph.putIfAbsent(edges[i][0], new HashMap<>());
            graph.putIfAbsent(edges[i][1], new HashMap<>());

            graph.get(edges[i][0]).put(edges[i][1], edges[i][2]);
            graph.get(edges[i][1]).put(edges[i][0], edges[i][2]);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        for (int i = 0; i < n; i++) {
            heap.offer(new int[] { i, 0 });
            int dist[] = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[i] = 0;
            while (!heap.isEmpty()) {
                int curr[] = heap.poll();
                int currnode = curr[0];
                int currdist = curr[1];

                for (int nb : graph.getOrDefault(currnode, new HashMap<>()).keySet()) {
                    int nextDistance = graph.get(currnode).get(nb);
                    if (currdist + nextDistance < dist[nb]) {
                        dist[nb] = currdist + nextDistance;
                        heap.offer(new int[] { nb, dist[nb] });
                    }
                }
            }
            int nodes = 0;
            for (int j = 0; j < n; j++) {
                if (dist[j] <= distanceThreshold)
                    nodes++;
            }
            if (nodes <= reachable) {
                ans = i;
                reachable = nodes;
            }
        }

        return ans;

    }
}
