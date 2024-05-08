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


// 优化判断是否斜对角线会攻击
class Solution {
    List<List<String>> ans = new ArrayList<>();
    int[] col; // 用来存放枚举的列号
    boolean[] visited;
    boolean[] diag1, diag2; // 用来标识是否放过皇后
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.visited = new boolean[n];
        this.col = new int[n];
        this.n = n;
        this.diag1 = new boolean[2 * n - 1];
        this.diag2 = new boolean[2 * n - 1];
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

                    diag1[i + j] = true;
                    diag2[i - j + n - 1] = true;
                    dfs(i + 1);
                    // 恢复现场
                    visited[j] = false;
                    diag1[i + j] = false;
                    diag2[i - j + n - 1] = false;
                }
                
            }
        }
    }
    public boolean isValid(int r, int c) {
        if(diag1[r + c] == true || diag2[r - c + n - 1] == true)
            return false;
        return true;
    }
}
