class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //左右子树都找到
        if(left != null && right != null) {
            return root;
        }
        // 只有左子树找到
        if(left != null) {
            return left;
        }
        return right;
    }
}
