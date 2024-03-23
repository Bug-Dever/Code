class Solution {
    public int maxSubArray(int[] nums) {
        int dp = nums[0], res = dp;
        for(int i = 1; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            res = Math.max(dp, res);
        }
        return res;
    }
}
