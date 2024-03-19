// 法一：
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            int[] count = new int[26];
            // 统计每一个str中各个字母出现的次数
            for(int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }
            // 将count组成字符串，作为Map的key
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i++) {
                if(count[i] != 0) {
                    sb.append((char)'a' + i);
                    sb.append(count[i]);
                }
            }
            String key = sb.toString();
            // 放入HashMap
            List<String> list = map.getOrDefault(key, new ArrayList<>()); // 如果key对应的list存在则返回，否则new一个
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
        
    }
}

// 法二：
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            // 由于str是不可改的，故转为char[]
            char[] array = str.toCharArray();
            Arrays.sort(array); // O(k·logk)
            String key = new String(array);

            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
