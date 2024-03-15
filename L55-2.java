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
// 从顶向下，容易想到，但时间复杂度高
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right); 

    }
    public int depth(TreeNode node) {
        if(node == null)
            return 0;
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
}

// 从底向上
