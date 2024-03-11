// dp
class Solution {
    public int jewelleryValue(int[][] frame) {
        int[][] dp = new int[frame.length][frame[0].length];
        // 初始化
        dp[0][0] = frame[0][0];
        // 首行
        for(int i = 1; i < frame[0].length; i++) {
            dp[0][i] = dp[0][i-1] + frame[0][i];
        }
        // 首列
        for(int j = 1; j < frame.length; j++) {
            dp[j][0] = dp[j-1][0] + frame[j][0];
        }
        for(int i = 1; i < frame.length; i++) {
            for(int j = 1; j < frame[0].length; j++) {
                dp[i][j] = dp[i][j-1] > dp[i-1][j] ? dp[i][j-1] + frame[i][j] : dp[i-1][j] + frame[i][j];
            }
        }
        return dp[frame.length - 1][frame[0].length - 1];
    }
}

// dp优化空间 把frame数组直接当成dp数组
class Solution {
    public int jewelleryValue(int[][] frame) {

        // 首行
        for(int i = 1; i < frame[0].length; i++) {
            frame[0][i] =frame[0][i-1] + frame[0][i];
        }
        // 首列
        for(int j = 1; j < frame.length; j++) {
            frame[j][0] = frame[j-1][0] + frame[j][0];
        }
        for(int i = 1; i < frame.length; i++) {
            for(int j = 1; j < frame[0].length; j++) {
                frame[i][j] = frame[i][j-1] > frame[i-1][j] ? frame[i][j-1] + frame[i][j] : frame[i-1][j] + frame[i][j];
            }
        }
        return frame[frame.length - 1][frame[0].length - 1];
    }
}

// 多开一行一列空间优化代码
class Solution {
    public int jewelleryValue(int[][] frame) {
        int[][] dp = new int[frame.length + 1][frame[0].length + 1];
        for(int i = 1; i < frame.length + 1; i++) {
            for(int j = 1; j < frame[0].length + 1; j++) {
                dp[i][j] = dp[i][j-1] > dp[i-1][j] ? dp[i][j-1] + frame[i-1][j-1] : dp[i-1][j] + frame[i-1][j-1];
            }
        }
        return dp[frame.length][frame[0].length];
    }
}
