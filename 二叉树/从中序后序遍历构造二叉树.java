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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recur(inorder, 0, inorder.length, postorder, 0, postorder.length, map);
    }

    public TreeNode recur(int[] inorder, int inL, int inR, int[] postorder, int postL, int postR, Map<Integer, Integer> map) {
        if(inL == inR)
            return null;
        
        // 在inorder中找到根
        int rightSize = inR - map.get(postorder[postR - 1]);

        //建树
        TreeNode root = new TreeNode(postorder[postR - 1]);
        root.right = recur(inorder, inR - rightSize + 1, inR, postorder, postR - rightSize, postR - 1, map);
        root.left = recur(inorder, inL, inR - rightSize, postorder, postL, postR - rightSize, map);
        return root;
    }
}
