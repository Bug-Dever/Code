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
// 法一：归并排序
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeSort(lists, 0, lists.length - 1);
    }
    public ListNode mergeSort(ListNode[] lists, int l, int r) {
        if(l > r) return null; // lists 为空的情况
        if(l == r) return lists[l];
        
        int mid = l + (r - l) / 2;
        ListNode left = mergeSort(lists, l, mid);
        ListNode right = mergeSort(lists, mid + 1, r);
        return mergeTwoList(left, right);
    }
    public ListNode mergeTwoList(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2;
        return dummy.next;
    }
}
