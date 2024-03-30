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
class Solution {
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return res;
    }
    public int depth(TreeNode root) {
        if(root == null)
            return -1;
        int l_len = depth(root.left);
        int r_len = depth(root.right);

        // 更新答案
        res = Math.max(res, l_len + r_len + 2);

        return Math.max(l_len, r_len) + 1;
    }
}
