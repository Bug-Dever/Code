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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) 
            return head;
        ListNode nummy = new ListNode(0);
        nummy.next = head;
        ListNode pre = nummy, start, end;
        while(pre.next != null && pre.next.next != null) {
            start = pre.next;
            end = pre.next.next;
            pre.next = end;
            start.next = end.next;
            end.next = start;
            pre = start;
        }
        return nummy.next;
    }
}
