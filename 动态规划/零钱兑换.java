// 完全背包
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int[][] dp = new int[m + 1][amount + 1];
        int MAX = amount + 1;
        for (int a = 1; a <= amount; a++) {
            dp[0][a] = MAX; // 防止溢出
        }
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= amount; j++) {
                if(coins[i - 1] > j) {
                    // 大于剩余容量，不选
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }

            }
        }
        return dp[m][amount] == MAX ? -1 : dp[m][amount];
    }
}

// 空间优化：一个数组
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int[] dp = new int[amount + 1];
        int MAX = amount + 1;
        for (int a = 1; a <= amount; a++) {
            dp[a] = MAX; // 防止溢出
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] > j) {
                    // 大于剩余容量，不选
                    dp[j] = dp[j];
                } else {
                    dp[j] = Math.min(dp[j], dp[j - coins[i - 1]] + 1);
                }
            }
        }

        return dp[amount] == MAX ? -1 : dp[amount];
    }
}
