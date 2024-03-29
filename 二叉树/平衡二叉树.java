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
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public int depth(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}

// 改进：若在递归过程中，计算深度时发现不是平衡的，则返回-1，不再继续递归
class Solution {
    public boolean isBalanced(TreeNode root) {

        return depth(root) != -1;
    }
    public int depth(TreeNode root) {
        if(root == null)
            return 0;
        int left = depth(root.left);
        if(left == -1) return -1;
        int right = depth(root.right);
        if(right == -1) return -1;

        if(Math.abs(left - right) > 1)
            return -1;
        return Math.max(left, right) + 1;
    }
}
