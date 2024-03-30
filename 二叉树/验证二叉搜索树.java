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
    boolean res = true;
    long pre = Long.MIN_VALUE, cur;
    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        return res;
    }
    public void inOrder(TreeNode root) {
        if(root == null)
            return;
        
        inOrder(root.left);
        cur = root.val;
        if(cur <= pre)
            res = false;
        pre = root.val;
        inOrder(root.right);
    }
}

// 中序遍历
class Solution {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        if(!isValidBST(root.left) || root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }
}

// 前序遍历
class Solution {
    public boolean isValidBST(TreeNode root) {
        return recur(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean recur(TreeNode root, long left, long right) {
        if (root == null)
            return true;
        long x = root.val;
        return left < x && x < right && recur(root.left, left, x) && recur(root.right, x, right);
    }
}
