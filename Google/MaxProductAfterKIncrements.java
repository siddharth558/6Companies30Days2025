package Google;

import java.util.PriorityQueue;

public class MaxProductAfterKIncrements {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
        }

        while (k > 0) {
            int top = pq.peek();
            pq.poll();
            top += 1;
            pq.offer(top);
            k--;
        }
        long prod = 1;
        while (!pq.isEmpty()) {
            prod = (prod * pq.poll()) % (int) (1e9 + 7);
        }

        return (int) prod;
    }
}
