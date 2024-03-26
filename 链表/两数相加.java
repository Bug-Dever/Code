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
// 自己写的💩
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0), res = node;
        int carry = 0; // 进位
        boolean flag1 = false, flag2 = false;
        while(!flag1 || !flag2 || carry == 1) {
            
            node.next = new ListNode((l1.val + l2.val + carry) % 10);
            carry = l1.val + l2.val + carry >= 10 ? 1 : 0;
            
            if(l1.next != null) {
                l1 = l1.next;
            } else {
                l1 = new ListNode(0);
                flag1 = true;
            }

            if(l2.next != null) {
                l2 = l2.next;
            } else {
                l2 = new ListNode(0);
                flag2 = true;
            }
            node = node.next;
        }
        return res.next;
    }
}

// 
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // 辅助节点
        ListNode pre = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            pre.next = new ListNode(sum % 10);
            carry = sum / 10;
            
            pre = pre.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) pre.next = new ListNode(carry);
        
        return dummy.next;
    }
}
