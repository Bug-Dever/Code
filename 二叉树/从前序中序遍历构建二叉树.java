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

// 思路简单，时空都是O(n^2) 可以优化
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recur(preorder, inorder);
        
    }
    public TreeNode recur(int[] preorder, int[] inorder) {
        // 作用：找到根节点、左右树的节点
        if(preorder.length == 0)
            return null;
        // 划分inorder
        int i = 0;
        while(true) {
            if(inorder[i] == preorder[0])
                break;
            i++;
        }
        // 获得子树的先序、中序遍历数组
        // 建树
        TreeNode root = new TreeNode(preorder[0]);
        root.left = recur(Arrays.copyOfRange(preorder, 1, 1 + i), Arrays.copyOfRange(inorder, 0, i));
        root.right = recur(Arrays.copyOfRange(preorder, 1 + i, preorder.length), Arrays.copyOfRange(inorder, 1 + i, inorder.length));
        return root;
    }
}

// 时空都是O(n)
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        // 将inorder加入到HashMap中
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return recur(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
        
    }
    public TreeNode recur(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR, Map<Integer, Integer> map) {
        // 作用：找到根节点、左右树的节点
        if(preL == preR) {
            return null;
        }
        // 左子树大小
        int leftSize = map.get(preorder[preL]) - inL;

        // 获得子树的先序、中序遍历数组
        // 建树
        TreeNode root = new TreeNode(preorder[preL]);
        root.left = recur(preorder, preL + 1, preL + 1 + leftSize, inorder, inL, inL + leftSize, map);
        root.right = recur(preorder, preL + 1 + leftSize, preR, inorder, inL + 1 + leftSize, inR, map);
        return root;
    }
}
