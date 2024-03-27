/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) 
            return null;
        // 复制节点
        Node cur = head;
        while(cur != null) {
            Node next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }

        // 复制随机节点
        cur = head;
        while(cur != null) {
            if(cur.random == null) {
                cur.next.random = null;
            } else {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // 拆分链表
        Node cur1 = head;
        Node node = head.next;
        Node cur2 = node;
        while(cur1 != null) {
            cur1.next = cur1.next.next;
            if(cur2.next == null) {
                cur2.next = null;
            } else {
                cur2.next = cur2.next.next;
            }
            
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return node;
    }
}


// 法二：使用HashMap，空间复杂度更高O(n)，但思路实现简单
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        // 定义HashMap存储<当前节点, 新增的节点>
        Map<Node, Node> map = new HashMap<>(); 
        Node cur = head;
        while(cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
