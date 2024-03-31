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
// 法一：迭代，先将左子树加在右子树上，然后右子树拼在最右节点上
class Solution {
    public void flatten(TreeNode root) {
        TreeNode tmp;
        while(root != null) {
            if(root.left == null) {
                root = root.right;
                continue;
            }
            // 暂存右节点
            tmp = root.right;
            // 左节点接到右节点
            root.right = root.left;
            root.left = null;
            // 找到新的最右节点
            TreeNode cur = root, rightest = root;
            while(cur.right != null) {
                rightest = cur.right;
                cur = cur.right;
            }
            // 原来的右子树接上去
            rightest.right = tmp;
            root = root.right;
        }
        
    }
}

// 法二：递归，真的牛b
// 递归： ①：作用：将树展开为链表 ②：输入：树的根节点 ③输出：无
class Solution {
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        // 展开左子树
        flatten(root.left);
        // 展开右子树
        flatten(root.right);

        TreeNode tmp = root.right;
        // 将左子树加到右边
        root.right = root.left;
        root.left = null;
        // 找到最右节点，并将右子树加在后面
        TreeNode cur = root;
        while(cur.right != null) {
            cur = cur.right;
        }
        cur.right = tmp;
    }
}
