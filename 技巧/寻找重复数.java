class Solution {
    public int findDuplicate(int[] nums) {
        // 原地哈希
        int tmp=0;
        while(true){
            tmp = nums[0];
            swap(nums, 0, nums[0]);
            if(nums[0] == tmp) return tmp;
        }
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
