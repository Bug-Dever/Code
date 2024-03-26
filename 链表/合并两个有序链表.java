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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list = new ListNode(0), head = list;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                list.next = list1;
                list1 = list1.next;
                
            } else {
                list.next = list2;
                list2 = list2.next;
                
            }
            list = list.next;
        }
        list.next = list1 == null ? list2 : list1;
        return head.next;
    }
}
