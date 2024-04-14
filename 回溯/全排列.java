class Solution {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    boolean[] visited; // 记录是否访问过
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        for(int num : nums) {
            list.add(num);
        }
        this.visited = new boolean[n];

        dfs(0, nums);

        return ans;
        
    }
    public void dfs(int i, int[] nums) {
        if(i == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int j = 0; j < nums.length; j++) {
            if(visited[j] == false) {
                path.add(nums[j]);
                visited[j] = true;
                dfs(i + 1, nums);

                // 退回
                visited[j] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
