class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int n;
    int[] candidates;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.n = candidates.length;
        this.candidates = candidates;
        dfs(0, target);
        return ans;
    }
    public void dfs(int i, int target) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int j = 0; j < n; j++) {
            if(path.isEmpty() || candidates[j] >= path.get(path.size() - 1)) {
                path.add(candidates[j]);
                target -= candidates[j];

                dfs(i + 1, target);
                // 恢复现场
                target += candidates[j];
                path.remove(path.size() - 1);
            }


        }
    }
}
