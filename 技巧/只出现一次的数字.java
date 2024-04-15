class Solution {
    public int singleNumber(int[] nums) {
        // 将所有数字按位异或
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}
