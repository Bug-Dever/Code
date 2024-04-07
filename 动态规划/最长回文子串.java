// 二维dp 时间空间O(n^2)
class Solution {
    public String longestPalindrome(String s) {
        int l = s.length();
        char[] arr = s.toCharArray();
        boolean[][] dp = new boolean[l][l];
        int start = 0, maxLen = 1;

        for(int i = 0; i < l; i++) {
            dp[i][i] = true;
        }
        for(int j = 1; j < l; j++) {
            for(int i = 0; i < j; i++) {
                // 如果首尾不等，直接返回false
                if(arr[i] != arr[j]) {
                    dp[i][j] = false;
                } else {
                    // 若字符串长度<=3
                    if(j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 记录最大的回文子串
                if(dp[i][j] == true && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
