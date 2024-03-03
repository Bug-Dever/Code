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
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) {
            return false;
        } else if(isSubTree(A,B)) {
            return true;
        } else {
            return (isSubStructure(A.left,B) || isSubStructure(A.right,B));
        }  

    }

    // 用于判断以A为根节点的树是否和B树相同
    public boolean isSubTree(TreeNode A, TreeNode B) {
        if(B == null) {
            return true;
        } else if(A == null || A.val != B.val) {
            return false;
        } else {
            // 递归判断左右子树是否相等
            return isSubTree(A.left,B.left) && isSubTree(A.right,B.right);
        }
    }

}
