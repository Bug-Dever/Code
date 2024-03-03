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
    public boolean checkSymmetricTree(TreeNode root) {
        if(root == null) {
            return true;
        } else {
            return recur(root.left,root.right);
        }
    }

    public boolean recur(TreeNode L, TreeNode R) {
        if(L == null && R == null) {
            return true;
        } else if(L == null || R == null || L.val != R.val) {
            return false;
        } else {
            return recur(L.left,R.right) && recur(L.right,R.left);
        }
    }
}
