// 也可以用长度为 26 的数组代替哈希表
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            if(map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else 
                map.put(c, 1);
            
        }
        for(char cc : t.toCharArray()) {
            if(map.containsKey(cc) && map.get(cc) > 0) {
                map.put(cc, map.get(cc) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
