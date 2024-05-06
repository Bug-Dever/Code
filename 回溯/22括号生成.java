// 选or不选   open:左括号的个数
class Solution {
    List<String> ans = new ArrayList<>();
    char[] path;
    int m, n;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        this.m = 2 * n;
        this.path = new char[m];

        dfs(0, 0);
        return ans;
    }
    public void dfs(int i, int open) {
        if(i == m) {
            ans.add(new String(path));
            return;
        }
        // 左括号个数小于n，可选左括号
        if(open < n) {
            path[i] = '(';
            dfs(i + 1, open + 1);
        }
        // 右括号个数小于左括号个数，可选右括号
        if(i - open < open) {
            path[i] = ')';
            dfs(i + 1, open);
        }
    }
}
