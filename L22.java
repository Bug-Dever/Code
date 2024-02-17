// 双指针
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
    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode former = head, latter = head;
        for(int i=cnt;i>0;i--) {
            former = former.next;
        }
        while(former!=null) {
            latter = latter.next;
            former = former.next;
        }
        return latter;
    }
}
