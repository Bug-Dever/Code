class Solution {
    public int majorityElement(int[] nums) {
        int vote = 0, target = 0;
        for(int i = 0; i < nums.length; i++) {
            if(vote == 0) target = nums[i];
            if(nums[i] == target) {
                vote++;
            } else {
                vote--;
            }
        }
        return target;
    }
}
