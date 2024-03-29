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
// 两个列表
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);
        while(!cur.isEmpty()) {
            List<TreeNode> nxt = new ArrayList<>();
            List<Integer> vals = new ArrayList<>();
            for(TreeNode node : cur) {
                vals.add(node.val);
                if(node.left != null)
                    nxt.add(node.left);
                if(node.right != null)
                    nxt.add(node.right);
                cur = nxt;
            }
            res.add(vals);
        }
        return res;
    }
}

// 队列
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> cur = new LinkedList<>();
        cur.offer(root);
        while(!cur.isEmpty()) {
            int n = cur.size(); // 获取队列长度
            List<Integer> vals = new ArrayList<>();
            while(n-- > 0) {
                TreeNode node = cur.poll();
                vals.add(node.val);
                if(node.left != null)
                    cur.offer(node.left);
                if(node.right != null)
                    cur.offer(node.right);
            }
            res.add(vals);
        }
        return res;
    }
}
