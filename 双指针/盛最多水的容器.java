class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, S = 0, res = 0;
        while(i < j) {
            S = (j - i) * Math.min(height[i], height[j]);
            res = res > S ? res : S;
            if(height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}
