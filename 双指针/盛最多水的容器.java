// 移动短的板，不移动长的板 （因为移动短的板后Math.min可能变大，但宽减小，面积可能增大；但移动长的板，肯定减小）
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
