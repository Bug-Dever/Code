// 分3种情况讨论染蓝色的情况
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length - 1;
        int i = -1, j = nums.length;
        while(i + 1 < j) {
            int mid = i + (j - i) / 2;
            if(isBlue(nums, mid, target)) {
                // 染蓝色
                j = mid;
            } else {
                i = mid;
            }
        }
        return nums[j] == target ? j : -1;
    }
    public boolean isBlue(int[] nums, int i, int target) {
        int n = nums.length - 1;
        if(nums[i] > nums[n]) {
            // i 在左边段
            return target > nums[n] && target <= nums[i];
        } else {
            // i 在右边段
            return target > nums[n] || target <= nums[i];
        }
    }
}
