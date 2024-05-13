法一：
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
        
        if(target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if(target < 0 || i == n) {
            return;
        }
        // 不选
        dfs(i + 1, target);
        // 选
        path.add(candidates[i]);
        dfs(i, target - candidates[i]); // 表示下一个数字还可以选 candidates[i]
        path.remove(path.size() - 1);

    }
}

// 法二：
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
        for(int j = i; j < n; j++) {
            
            path.add(candidates[j]);
            target -= candidates[j];

            dfs(j, target);
            // 恢复现场
            target += candidates[j];
            path.remove(path.size() - 1);
        }
    }
}
