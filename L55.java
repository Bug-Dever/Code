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
    int k = 0, res;
    public int findTargetNode(TreeNode root, int cnt) {
        this.k = cnt;
        inOrder(root); // 右 -> 根 -> 左
        return res;
    }
    public void inOrder(TreeNode node) {
        if(node == null)
            return;
        inOrder(node.right);
        k--;
        if(k == 0) {
            res = node.val;
        }
        inOrder(node.left);
    }
}



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
// BFS
class Solution {
    public int calculateDepth(TreeNode root) {
        if(root == null)
            return 0;
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>(), temp;
        queue.offer(root);
        while (!queue.isEmpty()) {
            temp = new LinkedList<>();
            for (TreeNode node : queue) {
                if (node.left != null) {
                    temp.offer(node.left);
                }
                if (node.right != null) {
                    temp.offer(node.right);
                }
            }
            queue = temp;
            res++;
        }
        return res;
    }
}
