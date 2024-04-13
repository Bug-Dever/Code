// 自己写的
class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map =new HashMap<>(); // map用来存每个字符最后的位置
        List<Integer> ans = new ArrayList<>();
        char[] arr = s.toCharArray();
        for(int m = arr.length - 1; m >= 0; m--) {
            if(!map.containsKey(arr[m]))
                map.put(arr[m], m);
        }
        int right = 0;
        for(int i = 0; i < arr.length; i = right + 1) {
            right = map.get(arr[i]);
            for(int j = i + 1; j < right; j++) {
                if(map.get(arr[j]) > right)
                    right = map.get(arr[j]);
            }
            ans.add(right - i + 1);
        }
        return ans;
    }
}

// 优化,更好的代码
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26]; // 用一个数组代替map来存储字符最后一次出现的位置
        List<Integer> ans = new ArrayList<>();
        char[] arr = s.toCharArray();
        for(int m = 0; m < arr.length; m++) {
            last[arr[m] - 'a'] = m;
        }
        int start = 0, end = 0;
        for(int i = 0; i < arr.length; i++) {
            end = Math.max(end, last[arr[i] - 'a']);
            if(i == end) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }
}
