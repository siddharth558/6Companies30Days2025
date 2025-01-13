package Walmart;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SubsquenceOfLengthK {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[] { nums[i], i });
            if (pq.size() > k) {
                pq.poll();
            }
        }

        Set<Integer> indices = new HashSet<>();
        int ans[] = new int[k];

        while (!pq.isEmpty()) {
            int curr[] = pq.poll();
            indices.add(curr[1]);
        }

        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (indices.contains(i)) {
                ans[p++] = nums[i];
            }
        }
        return ans;
    }
}
