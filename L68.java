/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 自己写的 辣鸡
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

// 递推 时间On 空间O1
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null) {
            if(p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if(p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }
}

// 递归 时间On 空间On
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if(p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
