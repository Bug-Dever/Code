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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return recur(preorder, 0, preorder.length, postorder, 0, postorder.length, map);
    }

    public TreeNode recur(int[] preorder, int preL, int preR, int[] postorder, int postL, int postR, Map<Integer, Integer> map) {
        if(preL == preR)
            return null;
        if(preL + 1 == preR)
            return new TreeNode(preorder[preL]);
        // 在postorder中找到根
        int leftSize = map.get(preorder[preL + 1]) - postL + 1;

        //建树
        TreeNode root = new TreeNode(preorder[preL]);
        root.left = recur(preorder, preL + 1, preL + 1 + leftSize, postorder, postL, postL + leftSize, map);
        root.right = recur(preorder, preL + 1 + leftSize, preR, postorder, postL + leftSize, postR - 1, map);
        return root;
    }
}
