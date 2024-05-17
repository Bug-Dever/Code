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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        while(dummy.next != null && dummy.next.next != null) {
            ListNode tmp1 = dummy.next;
            ListNode tmp2 = dummy.next.next.next;
            dummy.next = dummy.next.next;
            dummy.next.next = tmp1;
            tmp1.next = tmp2;
            dummy = dummy.next.next;
        }
        return node.next;
    }
}
