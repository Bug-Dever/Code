/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// 自己写的
class Solution {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        depth(root);
        return res;
    }
    public int depth(TreeNode root) {
        if(root == null)
            return 0;
        int l = depth(root.left);
        int r = depth(root.right);

        // 更新res
        if(l > 0 && r > 0) {
            res = Math.max(res, l + r + root.val);
        } else {
            res = Math.max(Math.max(Math.max(res, root.val), root.val + l), root.val + r);
        }
        
        return Math.max(l, r) > 0 ? Math.max(l, r) + root.val : root.val;
    }
}

// 优化以后
class Solution {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        depth(root);
        return res;
    }
    public int depth(TreeNode root) {
        if(root == null)
            return 0;
        int l = depth(root.left);
        int r = depth(root.right);

        // 更新res
        res = Math.max(res, l + r + root.val);
        
        return Math.max(Math.max(l, r) + root.val, 0);
    }
}
