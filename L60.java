// dp
class Solution {
    public double[] statisticsProbability(int num) {
        int[][] dp = new int[num+1][num*6+1];
        double[] res = new double[5*num+1];
        for(int j = 1; j <= 6; j++) {
            dp[1][j] = 1;
        }
        for(int i = 2; i <= num; i++) {
            for(int j = i; j <= i*6; j++) {
                for(int k = 1; k <= 6; k++) {
                    if(j-k < 1) break;
                    dp[i][j] += dp[i-1][j-k];
                }
            }
        }
        for(int i = 0; i < 5*num+1; i++) {
            res[i] = dp[num][num+i] / Math.pow(6,num);
        }
        return res;
    }
}

// dp 优化空间
