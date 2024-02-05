// BFS
class Solution {
    
    public int wardrobeFinishing(int m, int n, int cnt) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[m][n];
        int count = 0; // 用于计数
        queue.offer(new int[]{0,0,0,0});
        while(queue.size()>0) {
            int[] polled = queue.poll();
            int i = polled[0];
            int j = polled[1];
            int si = polled[2];
            int sj = polled[3];
            
            if(i>m-1 || j>n-1 || (si+sj)>cnt || visited[i][j]==1 ) continue;
            visited[i][j] = 1; // 标记为已经来过
            count++;
            queue.offer(new int[]{i+1,j,(i+1)%10==0?si-8:si+1,sj});
            queue.offer(new int[]{i,j+1,si,(j+1)%10==0?sj-8:sj+1});
        }
        return count;
    }
}
