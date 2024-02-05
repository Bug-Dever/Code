// DFS
class Solution {
    private int cnt, m, n;
    private int[][] visited;
    public int wardrobeFinishing(int m, int n, int cnt) {
        this.m = m;
        this.n = n;
        this.cnt = cnt;
        this.visited = new int[m][n];

        return dfs(0,0,0,0);
    }

    int dfs(int i, int j, int si, int sj) {
        if(i>m-1 || j>n-1 || si+sj>cnt || visited[i][j]==1) return 0;  // 四种返回0的情况
        visited[i][j] = 1; // 标记为已经遍历过了
        return 1 + dfs(i+1,j,(i+1)%10!=0?si+1:si-8,sj) + dfs(i,j+1,si,(j+1)%10!=0?sj+1:sj-8); // 向下和向右dfs搜索
    }
}
