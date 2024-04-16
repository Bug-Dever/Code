class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n <= 1) return;
        // 从后往前找到第一个 nums[i] < nums[i + 1]，此时i + 1 (j)到 end 一定是降序
        int i = n - 2, j = n - 1, k = n - 1;
        while(i >= 0 && nums[i] >= nums[j]) {
            i--; j--;
        }
        // 从end 到 j 从后往前找到第一个 nums[k] > nums[i]， 交换nums[i] 和 nums[k]
        if(i >= 0) { // 不是最后一个排序
            while(nums[i] >= nums[k]) {
                k--;
            }
            swap(nums, i, k);            
        }


        // 把nums[j] ~ end 升序排列(反一下即可，因为j ~ end 必为降序)
        while(j < n - 1) {
            swap(nums, j, n - 1);
            j++; n--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
