class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++) { // 遍历背包(s)
            for(int j = 0; j <= i; j++) { // 遍历物品(wordDict)
                String word = s.substring(j, i);       
                if (dp[j] && wordDict.contains(word))
                    dp[i] = true;        
            }       
        }
        return dp[s.length()];

    }
}
