/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;
        ListNode cur = head;
        while(cur != null) {
            length++;
            cur = cur.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = null, nxt, temp, l =dummy;
        cur = l.next;
        while(length >= k) {
            for(int i = 0; i < k; i++) {
                // 循环k次
                nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            // 处理其他节点
            temp = l.next;
            l.next.next = cur;
            l.next = pre;
            l = temp;
            length -= k; // 更新剩余链表长度
        }
        return dummy.next;
    }
}
