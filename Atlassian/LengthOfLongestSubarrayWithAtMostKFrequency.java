package Atlassian;

import java.util.HashMap;
import java.util.Map;

class LengthOfLongestSubarrayWithAtMostKFrequency {
    public int maxSubarrayLength(int[] nums, int k) {
        int r = 0, l = 0;
        int n = nums.length;
        Map<Integer, Integer> freqmap = new HashMap<>();
        int ans = 0;
        while (r < n) {
            freqmap.put(nums[r], freqmap.getOrDefault(nums[r], 0) + 1);
            while (freqmap.get(nums[r]) > k && l <= r) {
                freqmap.put(nums[l], freqmap.get(nums[l]) - 1);
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return ans;
    }
}
