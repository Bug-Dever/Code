class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // 特殊情况处理
        if(k <= 1) return 0;

        int i = 0, prod = 1, res = 0;
        for(int j = 0; j < nums.length; j++) {
            prod *= nums[j];
            while(prod >= k) {
                prod /= nums[i++];
            }
            res += (j - i + 1);
        }
        return res;
    }
}
