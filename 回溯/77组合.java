// 法一：输入视角 选不选
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int k;
    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        dfs(n);
        return ans;
    }
    public void dfs(int i) {
        // 剪枝
        if(i < k - path.size())
            return;
        // 记录答案
        if(path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 不选
        dfs(i - 1);
        // 选
        path.add(i);
        dfs(i - 1);
        path.remove(path.size() - 1);

    }
}

// 法二：答案视角 倒序枚举
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int k;
    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        dfs(n);
        return ans;
    }
    public void dfs(int i) {
        // 剪枝
        if(i < k - path.size())
            return;
        // 记录答案
        if(path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 倒序枚举
        for(int j = i; j > 0; j--) {
            path.add(j);
            dfs(j - 1);
            path.remove(path.size() - 1);
        }
    }
}
