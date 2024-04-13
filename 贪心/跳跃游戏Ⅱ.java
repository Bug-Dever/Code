class Solution {
    public int jump(int[] nums) {
        int maxDistance = 0, minStep = 0, end = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            if(i <= maxDistance && i + nums[i] > maxDistance) {
                maxDistance = i + nums[i];
            }
            if(i == end){
                minStep++;
                end = maxDistance;
            }
        }
        return minStep;
    }
}
