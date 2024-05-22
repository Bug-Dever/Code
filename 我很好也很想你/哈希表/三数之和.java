// 可以用 HashSet 来做，但是不如用双指针简单
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            // 剪枝
            if(nums[i] > 0)
                break;
            // 对nums[i]去重，注意要使用 i 和 i - 1，不能 i + 1 和 i
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1, right = nums.length - 1;

            while(left < right) {
                if(nums[i] + nums[left] + nums[right] > 0)
                    right--;
                else if(nums[i] + nums[left] + nums[right] < 0)
                    left++;
                else {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    // 对 left 和 right 去重
                    while(left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }

        }
        return ans;
    }
}
