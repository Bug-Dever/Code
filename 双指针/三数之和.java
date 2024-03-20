class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int i, j, k;
        for(i = 0; i < nums.length - 2; i++) {
            j = i + 1;
            k = nums.length - 1;
            // 两个节约时间的优化
            if(nums[i] + nums[i+1] + nums[i+2] > 0) break; // 最小的3个都大于0，break
            if(nums[i] + nums[k] + nums[k-1] < 0) continue; // num[i]+最大的两个都小于0，continue
            
            // 去除重复的三元组
            if(i > 0 && nums[i] == nums[i-1]) continue;

            while(j < k) {
                if(nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if(nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    list.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k])));
                    j++;

                    // 去除重复三元组
                    while(j < k && nums[j] == nums[j-1]) j++;
                }
            }
        }
        return list;
    }
}
