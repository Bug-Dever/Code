// 使用temp暂存cur的next结点
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
        ListNode cur = head, pre = null, temp;
        while(cur!=null) {
            temp = cur.next; // 用于暂存
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
