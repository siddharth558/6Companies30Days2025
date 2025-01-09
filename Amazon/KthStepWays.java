import java.util.HashMap;
import java.util.Map;

public class KthStepWays {
    int K;
    Map<String, Integer> dp;

    public int waysToReachStair(int k) {
        K = k;
        dp = new HashMap<>();
        int ans = func(1, 0, 1);
        return ans;
    }

    public int func(int i, int jump, int canJumpBack) {
        if (i > K + 1)
            return 0;
        String key = String.valueOf(i) + "_" + String.valueOf(jump) + "_" + String.valueOf(canJumpBack);
        int ways = 0;
        if (dp.containsKey(key))
            return dp.get(key);
        if (i == K) {
            ways += 1;
        }
        if (canJumpBack == 1) {
            ways += func(i - 1, jump, 0);
        }
        ways += func(i + (int) Math.pow(2, jump), jump + 1, 1);
        dp.put(key, ways);
        return ways;
    }
}
