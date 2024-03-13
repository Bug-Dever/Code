// 哈希表
class Solution {
    public char dismantlingAction(String arr) {

        Map<Character, Boolean> map = new HashMap<>();
        char res;
        int i;
        for(i = 0; i < arr.length(); i++) {
            if(!map.containsKey(arr.charAt(i))) {
                map.put(arr.charAt(i), true);
            } else {
                map.put(arr.charAt(i), false);
            }
        }  
        for(i = 0; i < arr.length(); i++) {
            if(map.get(arr.charAt(i)) == true) {
                break;
            }
        }
        return i < arr.length() ? arr.charAt(i) : ' ';
    }
}

// 法2：有序哈希表LinkedHashMap
class Solution {
    public char dismantlingAction(String arr) {

        Map<Character, Boolean> map = new LinkedHashMap<>();
        char res;
        int i;
        for(i = 0; i < arr.length(); i++) {
            map.put(arr.charAt(i), !map.containsKey(arr.charAt(i)));
        }  
        for(Map.Entry<Character, Boolean> m : map.entrySet()) {
            if(m.getValue()) {
                return m.getKey();
            }
        }
        return ' ';
    }
}
