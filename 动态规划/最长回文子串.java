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

// 中间扩散，时间O(n^2) 空间复杂度O(1)
class Solution {
    int start = 0, maxLen = 1;

    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length - 1; i++) {
            // 回文长度为奇数
            centerSpread(arr, i, i);
            // 回文长度为偶数
            centerSpread(arr, i, i + 1);
        }
        return s.substring(start, start + maxLen);
    }

    public void centerSpread(char[] arr, int i, int j) {
        while(i >= 0 && j < arr.length && arr[i] == arr[j]) {
            i--; j++;
        }
        if((j-1) - (i+1) + 1 > maxLen) {
            maxLen = j - i - 1;
            start = i + 1;
        }
    }
}


