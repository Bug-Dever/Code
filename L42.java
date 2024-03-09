// 动态规划dp 时间O(n) 空间O(n)
class Solution {
    public int maxSales(int[] sales) {
        if(sales == null || sales.length == 0)
            return 0;
        int[] dp = new int[sales.length];
        dp[0] = sales[0];
        int max = dp[0];
        for(int i = 1; i < sales.length; i++) {
            dp[i] = (sales[i]<dp[i-1]+sales[i]) ? dp[i-1]+sales[i] : sales[i];
            max = max > dp[i] ? max : dp[i];
        }
        return max;
    }
}

// 优化后 时间O(n) 空间O(1)
class Solution {
    public int maxSales(int[] sales) {
        if(sales == null || sales.length == 0)
            return 0;
        int dp = sales[0];
      
        int max = dp;
        for(int i = 1; i < sales.length; i++) {
            dp = (sales[i]<dp+sales[i]) ? dp+sales[i] : sales[i];
            max = max > dp ? max : dp;
        }
        return max;
    }
}
