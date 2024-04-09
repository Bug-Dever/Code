// dp 同时记录最大 最小值
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        int[] max = new int[n];
        min[0] = nums[0];
        max[0] = nums[0];

        int ans = nums[0];
        for(int i = 1; i < n; i++) {
            if(nums[i] < 0) {
                // 遇到负数，交换max和min
                int tmp = max[i - 1];
                max[i - 1] = min[i - 1];
                min[i - 1] = tmp;
            }
            max[i] = Math.max(max[i - 1] * nums[i], nums[i]);
            min[i] = Math.min(min[i - 1] * nums[i], nums[i]);
            ans = Math.max(ans, max[i]);
        }
        return ans;
    }
}

// 空间优化
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int min = 1;
        int max = 1;
        int ans = nums[0];

        for(int i = 0; i < n; i++) {
            if(nums[i] < 0) {
                // 遇到负数，交换max和min
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
