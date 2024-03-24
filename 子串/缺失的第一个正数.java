// 原地哈希
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            while(nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // 遍历数组，找到第一个缺失的正数
        for(int i = 0; i < n; i++) {
            if(nums[i] != (i + 1)) {
                return (i + 1);
            }
        }
        return (n + 1);
    }
    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
