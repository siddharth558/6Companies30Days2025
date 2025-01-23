package GoldmanSachs;

import java.util.HashSet;

public class KDivisibleSubarrays {
    public int countDistinct(int[] nums, int k, int p) {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            StringBuilder sb = new StringBuilder("");
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % p == 0)
                    cnt++;
                if (cnt > k)
                    break;

                sb.append(nums[j] + ",");
                set.add(sb.toString());
            }
        }

        return set.size();
    }
}
