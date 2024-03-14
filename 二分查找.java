// 二分查找的几种写法
// 1. 最原始的查找指定的元素的index (target仅存在一个)
int binarySearch(int[] nums, int target) {
    int left = 0, right = nums.length - 1, mid;
    while(left <= right) {
        mid = left + (right - left) / 2; // 防溢出
        if(nums[mid] < target) {
            left = mid + 1;
        } else if(nums[mid] > target) {
            right = mid - 1;
        } else {
            return mid;
        }
    }
    return -1;
}


// 2. 查找target的index范围 (target存在多个) 
int lower_bound(int[] nums, int target) {
    int left = 0, right = nums.length - 1, mid;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
}
int countTarget(int[] scores, int target) {
    int start = lower_bound(scores, target);
    if(start == scores.length || scores[start] != target) {
        return 0;
    }
    int end = lower_bound(scores, target + 1) - 1; // 这个转换很妙
    return (end - start) + 1;
}
