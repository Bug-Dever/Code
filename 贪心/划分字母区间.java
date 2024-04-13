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
