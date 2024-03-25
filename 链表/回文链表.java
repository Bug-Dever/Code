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
    public boolean isPalindrome(ListNode head) {
        if(head.next == null)
            return true;
        ListNode slow = head, fast = head, mid = null;
        while(fast != null) {
            mid = slow;
            slow = slow.next; // 慢指针
            fast = fast.next == null ? null : fast.next.next; // 快指针
        }
        // 慢指针指向了后半部分的头部
        // 反转
        ListNode start2 = reverse(slow);
        ListNode start1 = head;
        while(start2 != null) {
            if(start1.val != start2.val) 
                return false;
            start1 = start1.next;
            start2 = start2.next;
        }
        // 恢复后半链表，返回true
        mid.next = reverse(slow);
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head, temp;
        while(cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
