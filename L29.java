class Solution {
    public int[] spiralArray(int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return new int[0];
        }
        int l = 0, r = array[0].length - 1, t = 0, b = array.length - 1, i, j, k = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            for (i = t, j = l; j <= r; j++) {
                res[k++] = array[i][j];
            }
            t++;
            if(t>b) break;
            for (i = t, j = r; i <= b; i++) {
                res[k++] = array[i][j];
            }
            r--;
            if(r<l) break;
            for (i = b, j = r; j >= l; j--) {
                res[k++] = array[i][j];
            }
            b--;
            if(b<t) break;
            for (i = b, j = l; i >= t; i--) {
                res[k++] = array[i][j];
            }
            l++;
            if(l>r) break;
        }
        return res;
    }
}
