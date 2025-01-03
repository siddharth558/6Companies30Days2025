import java.util.Arrays;

public class WiggleSort {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int temp[] = new int[n];

        Arrays.sort(nums);
        int l = 0;
        int r = n - 1;
        int index = 0;
        while (l <= r) {
            temp[index++] = nums[l];
            temp[index++] = nums[r];
            l++;
            r--;
        }

        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }
}
