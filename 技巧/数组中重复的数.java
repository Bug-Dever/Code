class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            while(nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // 遍历数组，添加答案
        for(int i = 0; i < n; i++) {
            if(nums[i] != (i + 1)) {
                ans.add(nums[i]);
            }
        }
        return ans;        
    }
    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
