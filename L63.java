// dp
class Solution {
    public int bestTiming(int[] prices) {
        int dp = 0;
        int max = 0;
        for(int i = 1; i < prices.length; i++) {
            dp = dp + (prices[i] - prices[i-1]);
            dp = dp > 0 ? dp : 0;
            max = max > dp ? max : dp;
        }
        return max;
    }
}
