// 套用同向双指针模板
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        // 用一个数组来代替哈希表，存储p中各个字母的数量
        int[] count = new int[26];
        for(int i = 0; i < p.length(); i++) {
            count[p.charAt(i) - 'a']++;
        }

        int l = 0; // 左指针
        for(int r = 0; r < s.length(); r++) {
            count[s.charAt(r) - 'a']--;

            while(count[s.charAt(r) - 'a'] < 0) {
                count[s.charAt(l) - 'a']++;
                l++;
            }

            if(r - l + 1 == p.length()) {
                res.add(l);
            }
        }
        return res;
    }
}
