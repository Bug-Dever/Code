class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int a = nums[0], b = Math.max(nums[0], nums[1]), c;
        int res = Math.max(a, b);
        for(int i = 2; i < nums.length; i++) {
            c = Math.max(a + nums[i], b);
            res = Math.max(res, c);
            a = b;
            b = c;
        }
        return res;
    }
}
