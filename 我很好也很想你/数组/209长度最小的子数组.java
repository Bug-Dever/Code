// 滑动窗口
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, ans = Integer.MAX_VALUE, sum = 0;
        int n = nums.length;
        for(int j = 0; j < n; j++) {
            sum += nums[j];
            while(sum >= target) {
                ans = ans > (j - i + 1) ? (j - i + 1) : ans;
                sum -= nums[i];
                i++;
            }
        }
        return ans > n ? 0 : ans;
    }
}
