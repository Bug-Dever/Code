// 二分查找 自己写的递归，空间复杂度太大
class Solution {
    int count = 0;
    public int countTarget(int[] scores, int target) {
        binarySearch(scores, 0, scores.length - 1, target);
        return count;
    }
    public void binarySearch(int []nums, int left, int right, int target) {
        if(left > right) 
            return;
        int mid = (left + right) / 2;
        if(nums[mid] < target) {
            binarySearch(nums, mid+1, right, target);
        } else if(nums[mid] > target) {
            binarySearch(nums, left, mid-1, target);
        } else {
            count++;
            binarySearch(nums, left, mid-1, target);
            binarySearch(nums, mid+1, right, target);
        }
    }
}

// 空间复杂度O(1)做法
class Solution {
    int count = 0;
    public int countTarget(int[] scores, int target) {
        int start = lower_bound(scores, target);
        if(start == scores.length || scores[start] != target) {
            return 0;
        }
        int end = lower_bound(scores, target + 1) - 1;
        return (end - start) + 1;
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
