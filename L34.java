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
 // 二叉树的DFS，在DFS的同时计算路径值并记录
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int t;
    public List<List<Integer>> pathTarget(TreeNode root, int target) {
        this.t = target;
        dfs(root,0,new ArrayList<>());
        return res;
    }
    public void dfs(TreeNode root, int cur_sum, List<Integer> list) {
        if(root == null)
            return;
        list.add(root.val);
        if(root.left == null && root.right == null && (cur_sum+root.val) == t) {
            res.add(new ArrayList<>(list));
        }
        dfs(root.left, cur_sum+root.val, list);
        dfs(root.right, cur_sum+root.val, list);
        list.remove(list.size()-1);
    }
}
