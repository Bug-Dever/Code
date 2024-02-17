// 递归解法，不好理解
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
    public ListNode trainningPlan(ListNode head) {
        return recur(head,null);
    }


    ListNode recur(ListNode cur, ListNode pre) {
        if(cur == null) return pre;
        ListNode res = recur(cur.next,cur);
        cur.next = pre;
        return res;
    }
}
