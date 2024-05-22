// 在三数之和的基础上，再增加一层循环即可。但剪枝需要改变一下
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int first = 0; first < nums.length - 3; first++) {
            // 剪枝
            if(nums[first] > target && target > 0)
                break;
            // 对 first 去重
            if(first > 0 && nums[first] == nums[first - 1])
                continue;
            for(int i = first + 1; i < nums.length - 2; i++) {
                // 二次剪枝
                if(nums[first] + nums[i] > target && target > 0)
                    break;
                // 对 i 去重
                if(i > first + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1, right = nums.length - 1;
                while(left < right) {
                    long sum = (long)nums[first] + nums[i] + nums[left] + nums[right]; // 防止溢出
                    if(sum > target)
                        right--;
                    else if(sum < target)
                        left++;
                    else {
                        ans.add(Arrays.asList(nums[first], nums[i], nums[left], nums[right]));
                        left++;

                        // 对 left 和 right 去重
                        while(left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
