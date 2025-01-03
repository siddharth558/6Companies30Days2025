import java.util.Arrays;

public class minMoves {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int median = 0;
        if (n % 2 == 0) {
            median = (nums[n / 2] + nums[n / 2 - 1]) / 2;
        } else {
            median = nums[n / 2];
        }

        int moves = 0;
        for (int i = 0; i < n; i++) {
            moves += Math.abs(nums[i] - median);
        }

        return moves;
    }
}
