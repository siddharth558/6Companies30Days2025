package Walmart;

import java.util.HashMap;
import java.util.Map;

public class KDiffPairs {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;

        for (int element : nums)
            map.put(element, map.getOrDefault(element, 0) + 1);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            if (k == 0) {
                if (entry.getValue() > 1)
                    cnt++;
                // so if we simulate then we will see that if k is 0, then the number of pairs
                // which are getting formed is the frequency of the key itself.
            } else {
                if (map.containsKey(entry.getKey() + k))
                    cnt++;
            }
        }
        return cnt;
    }
}
