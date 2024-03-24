class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        Set<Integer> row = new HashSet<>(); // 记录0的横坐标
        Set<Integer> colum = new HashSet<>(); // 记录0的纵坐标
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    row.add(i);
                    colum.add(j);
                }
            }
        }

        // 根据0的坐标 将矩阵置0
        for(Integer r : row) {
            for(int j = 0; j < m; j++) {
                matrix[r][j] = 0;
            }
        }

        for(Integer c : colum) {
            for(int i = 0; i < n; i++) {
                matrix[i][c] = 0;
            }
        }
    }
}
