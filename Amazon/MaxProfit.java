import java.util.Arrays;

public class MaxProfit {
    int dp[][];

    public int solve(int prices[], int t, int d) {
        if (d == prices.length || t == 0)
            return 0;
        if (dp[d][t] != -1)
            return dp[d][t];

        int skip = solve(prices, t, d + 1);
        boolean canBuy = (t % 2 == 0);
        int transact = 0;
        if (canBuy) {
            transact = -prices[d] + solve(prices, t - 1, d + 1);
        } else {
            transact = prices[d] + solve(prices, t - 1, d + 1);
        }

        return dp[d][t] = Math.max(skip, transact);
    }

    public int maxProfit(int k, int[] prices) {
        dp = new int[prices.length][2 * k + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(prices, 2 * k, 0);
    }
}
