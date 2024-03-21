class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, res = 0;
        while(i < s.length() && j < s.length()) {
            if(map.containsKey(s.charAt(j))) {
                // 存在，更新i，更新map，更新res
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            // 不存在，加入map，j右移，更新res
            map.put(s.charAt(j), j);
            j++;
            res = res > (j - i) ? res : (j - i);
        }
        return res;
    }
}
