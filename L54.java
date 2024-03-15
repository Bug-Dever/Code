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
 // 中序遍历 自己写的
class Solution {
    public int findTargetNode(TreeNode root, int cnt) {
        List<TreeNode> list = new ArrayList<>();
        inOrder(root, list);
        // 返回倒数第cnt个
        return list.get(list.size()-cnt).val;
    }
    public void inOrder(TreeNode node, List<TreeNode> list) {
        if(node == null)
            return;
        inOrder(node.left, list);
        list.add(node);
        inOrder(node.right, list);
    }
}

// 优化时间，倒序遍历(得到递减的序列)，提前返回
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
