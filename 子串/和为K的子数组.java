class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        // 前缀和为0的有1组
        map.put(0, 1);
        // 前缀和
        int pre = 0;
        for(int i = 0; i < nums.length; i++) {
            pre = pre + nums[i];
            if(map.containsKey(pre-k)) {
                res += map.get(pre-k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return res;
    }
}
