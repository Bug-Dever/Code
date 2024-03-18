/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return recur(root, p, q);
    }
    public TreeNode recur(TreeNode node, TreeNode p, TreeNode q) {
        if(p == node || q == node) {
            return p == node ? p : q;
        }
        if((p.val < node.val && q.val > node.val) || (p.val > node.val && q.val < node.val)) {
            return node;
        }
        if(p.val < node.val && q.val < node.val) {
            return recur(node.left, p, q);
        }
        if(p.val > node.val && q.val > node.val) {
            return recur(node.right, p, q);
        }
        return null;
    }
}
