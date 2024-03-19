// 法一：
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        // 使用set过滤重复值
        for(int num : nums) {
            set.add(num);
        }
        for(int num : set) {
            if(set.contains(num - 1)) continue;
            int cur = 0;
            while(set.contains(num++)) {
                cur++;
            }
            res = res > cur ? res : cur;
        }
        return res;
    }
}

// 法二：
class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int num : nums) {
            if(!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                map.put(num, 1);
                int length = left + 1 + right;
                res = length > res ? length : res;

                map.put(num - left, length);
                map.put(num + right, length);
            }
        }
        return res;
    }
}
