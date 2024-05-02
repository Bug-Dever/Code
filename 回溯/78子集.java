// 
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int n;
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        dfs(0);
        return ans;
    }
    public void dfs(int i) {
        if(i == n) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 不选
        dfs(i + 1);
        // 选
        path.add(nums[i]);
        dfs(i + 1);
        // 恢复现场
        path.remove(path.size() - 1);
    }
}
