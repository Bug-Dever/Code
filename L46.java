// dp
class Solution {
    public int crackNumber(int ciphertext) {
        // 把int转换为String数组
        char[] arr = String.valueOf(ciphertext).toCharArray();
        int[] dp = new int[arr.length+1];
        // 初始化
        dp[0] = 1; dp[1] = 1;
        for(int i = 2; i <= arr.length; i++) {
            if((arr[i-2]-'0')*10+(arr[i-1]-'0')>=10 && (arr[i-2]-'0')*10+(arr[i-1]-'0')<=25) {
                dp[i] = dp[i-1] + dp[i-2];
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[arr.length];
    }
}

// dp优化
class Solution {
    public int crackNumber(int ciphertext) {
        // 把int转换为String数组
        char[] arr = String.valueOf(ciphertext).toCharArray();
        // 初始化
        int a = 1, b = 1, c;
        for(int i = 2; i <= arr.length; i++) {
            if((arr[i-2]-'0')*10+(arr[i-1]-'0')>=10 && (arr[i-2]-'0')*10+(arr[i-1]-'0')<=25) {
                c = a + b;
            } else {
                c = b;
            }
            a = b;
            b = c;
        }
        return c;
    }
}
