class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, res = Integer.MAX_VALUE;
        int sum = 0;
        for(int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while(sum >= target) {
                res = res > (j - i + 1) ? (j - i + 1) : res;
                sum -= nums[i++];
            }
        }
        return res <= nums.length ? res : 0;
    }
}
