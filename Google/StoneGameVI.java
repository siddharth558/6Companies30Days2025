package Google;

import java.util.PriorityQueue;

public class StoneGameVI {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < n; i++) {
            pq.add(new int[] { aliceValues[i] + bobValues[i], i });
        }

        int aliceScore = 0, bobScore = 0;
        boolean aliceTurn = true;

        while (!pq.isEmpty()) {
            int[] stone = pq.poll();
            int index = stone[1];

            if (aliceTurn) {
                aliceScore += aliceValues[index];
            } else {
                bobScore += bobValues[index];
            }

            aliceTurn = !aliceTurn;
        }

        if (aliceScore > bobScore) {
            return 1;
        } else if (aliceScore < bobScore) {
            return -1;
        } else {
            return 0;
        }
    }
}
