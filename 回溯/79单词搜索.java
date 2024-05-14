class Solution {
    boolean[][] visited;
    char[][] board;
    char[] word;
    int n, m;
    public boolean exist(char[][] board, String word) {
        this.n = board.length;
        this.m = board[0].length;
        this.word = word.toCharArray();
        this.board = board;
        visited = new boolean[n][m];
        // 枚举单词开始的位置
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(dfs(0, i, j)) return true;
            }
        }
        return false;
    }
    public boolean dfs(int i, int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= m || board[x][y] != word[i] || visited[x][y] == true) {
            return false;
        }
        visited[x][y] = true;
        if(i == word.length - 1) {
            return true;
        }
        boolean ans = dfs(i + 1, x - 1, y) || dfs(i + 1, x + 1, y) || dfs(i + 1, x, y - 1) || dfs(i + 1, x, y + 1);
        // 恢复现场
        visited[x][y] = false;
        return ans;
    }
}
