
class Solution {
    int solve(int i, int buy, int limit, int[] prices, int[][][] dp) {
        if (i == prices.length || limit == 0) return 0;
        if (dp[i][buy][limit] != -1)  return dp[i][buy][limit];

        int profit;
        if (buy == 1) {
            int take = -prices[i] + solve(i + 1, 0, limit, prices, dp);
            int skip = solve(i + 1, 1, limit, prices, dp);
            profit = Math.max(take, skip);
        } 
        else {
            int sell = prices[i] + solve(i + 1, 1, limit - 1, prices, dp);
            int skip = solve(i + 1, 0, limit, prices, dp);
            profit = Math.max(sell, skip);
        }
        return dp[i][buy][limit] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0, 1, 1, prices, dp);
    }
}
