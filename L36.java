/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    Node pre,head;
    public Node treeToDoublyList(Node root) {
        if(root == null)
            return null;
        recur(root);
        // 处理首尾节点
        pre.right = head;
        head.left = pre;
        return head;
    }
    // 中序遍历
    public void recur(Node cur) {
        if(cur == null) 
            return;
        recur(cur.left);
        
        if(pre == null) {
            // 如果是第一个
            head = cur;
            pre = cur;
        } else {
            pre.right = cur;
            cur.left = pre;
            pre = cur;        
        }
        
        recur(cur.right);
    }
}
