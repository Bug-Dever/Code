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
// 中序遍历，遍历到第k个就返回
class Solution {
    int cnt = 0;
    int res = -1;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return res;
    }
    public void inOrder(TreeNode root, int k) {
        if(root == null)
            return;
        if(res != -1)
            return;
        inOrder(root.left, k);
        cnt++;
        if(cnt == k) {
            res = root.val;
            return; // 提前返回
        }
        inOrder(root.right, k);
    }
}
