// 法一：
class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (i < nums.length && j < nums.length) {
            // i找第一个0元素，j找第一个非零元素
            if(nums[i] != 0) {
                nums[j] = nums[i];
                i++;
                j++;
            } else {
                i++;
            }
        }
        while(j < nums.length) {
            nums[j++] = 0;
        }
    }
}

// 法二：类似快排
class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0, temp;
        for(i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}
