package Atlassian;

import java.util.PriorityQueue;

public class KthLargest {
    private int k;
    private PriorityQueue<Integer> min_heap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        min_heap = new PriorityQueue<>(k);
        for (int num : nums)
            add(num);
    }

    public int add(int val) {
        if (min_heap.size() < k) {
            min_heap.offer(val);
        } else {
            if (min_heap.peek() < val) {
                min_heap.poll();
                min_heap.offer(val);
            }
        }
        return min_heap.peek();
    }
}
