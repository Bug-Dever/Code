// dfs
class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }
    public void dfs(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}

// bfs
class Solution {
    Queue<int []> queue = new LinkedList<>();
    public int numIslands(char[][] grid) {
        int ans = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    ans++;
                    bfs(grid, i, j);
                }
            }
        }
        return ans;
    }
    public void bfs(char[][] grid, int i, int j) {
        queue.offer(new int[]{i, j});
        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            i = arr[0]; j = arr[1];
            if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
                continue;
            grid[i][j] = '0';
            queue.offer(new int[]{i - 1, j});
            queue.offer(new int[]{i + 1, j});
            queue.offer(new int[]{i, j - 1});
            queue.offer(new int[]{i, j + 1});           
        }
        
    }
}
