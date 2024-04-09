class Solution {
    public int findPeakElement(int[] nums) {
        // 使用开区间写法
        int i = -1, j = nums.length - 1; // (i, j - 1)，最后一个默认为蓝色
        while(i + 1 < j) {
            int mid = i + (j - i) / 2;
            if(nums[mid] < nums[mid + 1]) {
                i = mid; // (mid, j)
            } else {
                j = mid; // (i, mid)
            }
        }
        return j;
    }
}
