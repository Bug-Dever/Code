// 法一：选或不选
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int k;
    int n;
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.n = n;
        dfs(9);
        return ans;
    }
    public void dfs(int i) {
        // 剪枝
        int d = k - path.size();
        if(i < d || n < 0 || n > (i + i - d + 1) * d / 2)
            return;
        
        if(path.size() == k && n == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 不选
        dfs(i - 1);
        // 选
        path.add(i);
        n -= i;
        dfs(i -1);
        // 恢复现场
        n += i;
        path.remove(path.size() - 1);
    }
}

// 法二：倒序枚举，剪枝
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int k;
    int n;
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.n = n;
        dfs(9);
        return ans;
    }
    public void dfs(int i) {
        // 剪枝
        int d = k - path.size();
        if(i < d || n < 0 || n > (i + i - d + 1) * d / 2)
            return;
        
        if(path.size() == k && n == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int j = i; j > 0; j--) {
            path.add(j);
            n -= j;
            dfs(j - 1);
            // 恢复现场
            n += j;
            path.remove(path.size() - 1);
        }
    }
}
