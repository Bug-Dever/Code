// 无重复元素写法
class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0, j = nums.length - 1, mid;
        while(i <= j) {
            mid = i + (j - i) / 2;
            if(nums[mid] > target) {
                j = mid - 1;
            }
            else if(nums[mid] < target) {
                i = mid + 1;
            } else {
                return mid;
            }
        }
        return i;
    }
}

// 若有重复元素，当nums[mid] = target时，j = mid - 1;
class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0, j = nums.length - 1, mid;
        while(i <= j) {
            mid = i + (j - i) / 2;
            if(nums[mid] > target) {
                j = mid - 1;
            }
            else if(nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
}
