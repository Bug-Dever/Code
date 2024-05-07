class Solution {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> s = new ArrayList<>();
    boolean[] visited;
    int[] nums;
    int n;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        visited = new boolean[n];
        dfs(0, visited);

        return ans;
        
    }
    public void dfs(int i, boolean[] visited) {
        if(i == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int j = 0; j < n; j++) {
            if(visited[j] == false) {
                path.add(nums[j]);
                visited[j] = true;
                dfs(i + 1, visited);

                // 恢复现场
                visited[j] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
