// 法一：
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

// 法二：
class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if(i == nums[i]) {
                i++;
                continue;
            }
            if(nums[i] == nums[nums[i]]) {
                return nums[i];
            }

            int tmp = nums[i];
            nums[i] = nums[nums[i]];
            nums[tmp] = tmp;
        }
        return -1;
    }
}
