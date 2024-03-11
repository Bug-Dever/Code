// 双指针用作滑动窗口，哈希表来存储
class Solution {
    public int dismantlingAction(String arr) {
        Map<Character, Integer> map = new HashMap<>();
        int i = -1, j;
        int res = 0;
        for(j = 0; j < arr.length(); j++) {
            if(!map.containsKey(arr.charAt(j))) {
                map.put(arr.charAt(j),j);
            } else {
                i = i < map.get(arr.charAt(j)) ? map.get(arr.charAt(j)) : i; // 这里要注意abba这种特例时，i要尽可能取大的值
                map.put(arr.charAt(j),j);
            }
            res = j-i > res ? j-i : res;
        }
        return res;
    }
}

// 动态规划 + 哈希表
class Solution {
    public int dismantlingAction(String arr) {
        if(arr == null || arr.length() <= 0)
            return 0;
        Map<Character, Integer> map = new HashMap<>();
        int res = 1;
        int[] dp = new int[arr.length()];
        dp[0] = 1;
        map.put(arr.charAt(0), 0);
        for(int i = 1; i < arr.length(); i++) {
            if(map.containsKey(arr.charAt(i))) {
                // 出现过
                int k = map.get(arr.charAt(i));
                if(i - k <= dp[i - 1]) {
                    dp[i] = i - k;
                } else {
                    dp[i] = dp[i - 1]  + 1;
                }
            } else {
                dp[i] = dp[i - 1]  + 1;
            }
            map.put(arr.charAt(i),i);
            res = res > dp[i] ? res : dp[i];
        }
        return res;
    }
}
