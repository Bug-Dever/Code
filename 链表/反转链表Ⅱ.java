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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l = dummy;
        for(int i = 0; i < left - 1; i++) {
            // 循环left - 1次
            l = l.next;
        }

        // 反转链表
        ListNode pre = null, cur = l.next, nxt;
        for(int i = 0; i < right - left + 1; i++) {
            // 循环right - left + 1次
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        // 处理其他节点
        l.next.next = cur;
        l.next = pre;

        return dummy.next;
    }
}
