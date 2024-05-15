class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length - 1;
        int[] ans = new int[n + 1];
        int left = 0, right = n;
        while(left <= right) {
            if(Math.abs(nums[left]) > Math.abs(nums[right])) {
                ans[n--] = nums[left] * nums[left];
                left++;
            } else {
                ans[n--] = nums[right] * nums[right];
                right--;
            }
        }
        return ans;
    }
}
