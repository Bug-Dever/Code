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
// 灵做法，先序遍历反一下，同时根据列表长度和深度，判断是否加入到结果中
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        recur(root, 0);
        return res;
    }
    public void recur(TreeNode root, int depth) {
        if(root == null)
            return;
        if(res.size() == depth)
            res.add(root.val);
        recur(root.right, depth + 1);
        recur(root.left, depth + 1);

    }
}

 // 用两个列表实现bfs
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList(0);
        bfs(root);
        return res;
    }
    public void bfs(TreeNode root) {
        List<TreeNode> l1 = new ArrayList<>();
        l1.add(root);
        while(!l1.isEmpty()) {
            List<TreeNode> l2 = new ArrayList<>();
            res.add(l1.get(0).val);
            for(TreeNode node : l1) {
                if(node.right != null)
                    l2.add(node.right);
                if(node.left != null)
                    l2.add(node.left);
            }
            l1 = l2;
        }
    }
}
