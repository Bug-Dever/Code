// 两次二分
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix.length - 1;
        while(i <= j) {
            int mid = i + (j - i) / 2;
            if(matrix[mid][0] < target) {
                i = mid + 1;
            } else if(matrix[mid][0] > target) {
                j = mid - 1;
            } else {
                return true;
            }
        }
        // 第 j 行就是所在行
        if(j < 0) return false;
        int m = 0, n = matrix[j].length - 1;
        while(m <= n) {
            int mid = m + (n - m) / 2;
            if(matrix[j][mid] < target) {
                m = mid + 1;
            } else if(matrix[j][mid] > target) {
                n = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
