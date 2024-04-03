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
    Map<Long, Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        map.put(0L, 1);
        return recur(root, 0L, targetSum);
    }
    public int recur(TreeNode root, long curSum, int targetSum) {
        if(root == null)
            return 0;
        // 更新curSum
        curSum += root.val;
        // 判断有无符合要求的前缀和
        int res = 0;
        if(map.get(curSum - targetSum) != null) {
            res += map.get(curSum - targetSum);
        }
        // 更新map
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);

        int left = recur(root.left, curSum, targetSum);
        int right = recur(root.right, curSum, targetSum);

        res = res + left + right;
        // 恢复状态
        map.put(curSum, map.get(curSum) - 1);

        return res;
    }
}
