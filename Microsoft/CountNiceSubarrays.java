public class CountNiceSubarrays {
    public int solve(int nums[], int k) {
        int l = 0, r = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] % 2;
        }
        int sum = 0;
        int subarrays = 0;
        while (r < n) {
            sum += nums[r];
            while (sum > k) {
                sum -= nums[l];
                l++;
            }
            if (sum <= k)
                subarrays += (r - l + 1);
            r++;
        }
        return subarrays;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        return solve(nums, k) - solve(nums, k - 1);
    }

}
