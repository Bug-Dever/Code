// 动态规划，两个数组存储前后缀的最大值 时间复杂度O(n) 空间复杂度O(n)
class Solution {
    public int trap(int[] height) {
        // 动态规划
        int n = height.length;
        int[] pre = new int[n];
        int[] post = new int[n];
        int res = 0;
        pre[0] = height[0]; post[n - 1] = height[n - 1];
        // 获取前缀最大值
        for(int i = 1; i < n; i++) {
            pre[i] = Math.max(pre[i - 1], height[i]);
        }
        // 获取后缀最大值
        for(int j = n - 2; j >= 0; j--) {
            post[j] = Math.max(post[j + 1], height[j]);
        }
        // 计算接雨水答案
        for(int k = 0; k < n; k++) {
            res += (Math.min(post[k], pre[k]) - height[k]);
        }
        return res;
    }
}

// 双指针 时间复杂度O(n) 空间复杂度O(1)
class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int leftMax = height[0], rightMax = height[height.length - 1];
        int res = 0;
        while(l < r) {
            leftMax = Math.max(height[l], leftMax);
            rightMax = Math.max(height[r], rightMax);
            if(leftMax < rightMax) {
                res += leftMax - height[l];
                l++;
            } else {
                res += rightMax - height[r];
                r--;
            }
        }
        return res;
    }
}
