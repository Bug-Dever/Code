/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// ------------------ my ------------------
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode prev, first;
        first = head;
        // 特例:若第一个节点就是目标节点
        if(head.val==val) {
            return head.next;
        } 
        while(head.next!=null) {
            prev = head;
            head = head.next;
            if(head.val==val) {
                // 执行删除操作
                prev.next = head.next;
                return first;
            }
        }
        // 未找到
        return null;
    }
}


// ------------------ answer ------------------
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) return head.next;
        ListNode pre = head, cur = head.next;
        while(cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if(cur != null) pre.next = cur.next;
        return head;
    }
}
