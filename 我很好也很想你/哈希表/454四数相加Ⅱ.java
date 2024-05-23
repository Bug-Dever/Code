class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        // 将数组 A + 数组 B 的结果及其出现次数存入 map 中
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                map.put(nums1[i] + nums2[j], map.getOrDefault(nums1[i] + nums2[j], 0) + 1);
            }
        }

        int ans = 0;
        for(int m = 0; m < nums3.length; m++) {
            for(int n = 0; n < nums4.length; n++) {
                    ans += map.getOrDefault(0 - nums3[m] - nums4[n], 0);
            }
        }
        return ans;
    }
}
