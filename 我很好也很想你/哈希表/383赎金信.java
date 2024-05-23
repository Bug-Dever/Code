class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        char[] m = magazine.toCharArray();
        for(char c : m) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        char[] r = ransomNote.toCharArray();
        for(char c : r) {
            if(!map.containsKey(c) || map.get(c) <= 0)
                return false;
            map.put(c, map.get(c) - 1);
        }
        return true;
    }
}
