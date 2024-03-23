class Solution {
    // 先计算左侧乘积(利用结果数组暂存)，再乘上右侧乘积
    public int[] productExceptSelf(int[] nums) {
        // res[i] 为 i 左侧所有元素的乘积
        int[] res = new int[nums.length];
        res[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int temp = 1;
        for(int j = nums.length - 1; j >= 0; j--) {
            res[j] = res[j] * temp;
            temp *= nums[j];
        }
        return res;
    }
}
