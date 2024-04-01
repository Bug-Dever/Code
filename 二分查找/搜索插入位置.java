class Solution {
    public int searchInsert(int[] nums, int target) {
        return binarySort(nums, target, 0, nums.length - 1);
    }
    public int binarySort(int[] nums, int target, int left, int right) {
        if(left > right)
            return left;
        int mid = left + (right - left) / 2;
        if(nums[mid] < target) {
            return binarySort(nums, target, mid + 1, right);
        } else {
            return binarySort(nums, target, left, mid - 1);
        }
    }
}
