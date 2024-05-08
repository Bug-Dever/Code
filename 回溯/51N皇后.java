class Solution {
    List<List<String>> ans = new ArrayList<>();
    int[] col; // 用来存放枚举的列号
    boolean[] visited;
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.visited = new boolean[n];
        this.col = new int[n];
        this.n = n;

        dfs(0);
        return ans;
    }
    public void dfs(int i) {
        if(i == n) {
            List<String> tmp = new ArrayList<>();
            for(int c : col) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[c] = 'Q';
                tmp.add(new String(row));
            }
            ans.add(tmp);
            return;
        }
        for(int j = 0; j < n; j++) {
            if(visited[j] == false) {
                if(isValid(i, j)) {
                    visited[j] = true;
                    col[i] = j;
                    dfs(i + 1);
                    // 恢复现场
                    visited[j] = false;                    
                }
                
            }
        }
    }
    public boolean isValid(int r, int c) {
        // 枚举 0 ~ r - 1 行
        for(int R = 0; R < r; R++) {
            int C = col[R];
            if((r + c == R + C) || (r - c == R - C))
                return false;
        }
        return true;
    }
}
