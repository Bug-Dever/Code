class Solution {
    public int orangesRotting(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    dfs(grid, i, j, 2);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
                max = max > grid[i][j] - 2 ? max : grid[i][j] - 2;
            }
        }        
        return max;
    }
    public void dfs(int[][] grid, int i, int j, int time) {
        // 情况一：超出边界的情况
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return;
        // 情况二：是烂橘子，但不是最短路径的情况
        if(grid[i][j] != 1 && grid[i][j] < time)
            return;
        grid[i][j] = time;
        dfs(grid, i - 1, j, time + 1);
        dfs(grid, i + 1, j, time + 1);
        dfs(grid, i, j - 1, time + 1);
        dfs(grid, i, j + 1, time + 1);
    }
}
