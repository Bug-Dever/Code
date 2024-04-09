class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = lower_bound(nums, target);
        if(start == nums.length || nums[start] != target) {
            return new int[]{-1,-1};
        }
        int end = lower_bound(nums, target + 1) - 1;
        return new int[]{start,end};
    }
    public int lower_bound(int []nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while(left <= right) {
            mid = (left + right) / 2;
            if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
