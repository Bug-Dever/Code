// 蛇皮走位法
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 以左下角为原点建立坐标系
        int i = matrix.length - 1, j = 0;
        while(i >= 0 && j <= matrix[0].length - 1) {
            if(matrix[i][j] > target) {
                i--;
            } else if(matrix[i][j] < target) {
                j++;
            } else{
                return true;
            }
        }
        return false;
    }
}
