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
    public TreeNode mirrorTree(TreeNode root) {
        TreeNode r = root; // 暂存
        if(root == null) { 
            return null; // 越过叶子节点，返回null
        }
        swap(root);
        mirrorTree(root.left);
        mirrorTree(root.right);
        return r;
    }
    public void swap(TreeNode node) {
        TreeNode temp;
        temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
