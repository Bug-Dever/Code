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
class Solution {
    public List<List<Integer>> decorateRecord(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isEven = false; // 用于标记偶数行
        List<List<Integer>> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> vals = new ArrayList<>(size);
            while (size-- > 0) {
                TreeNode node = queue.poll();
                vals.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if(isEven) {
                Collections.reverse(vals); //若为偶数行，反转vals
            }
            list.add(vals);
            isEven = !isEven;
        }        
        return list;

    }
}
