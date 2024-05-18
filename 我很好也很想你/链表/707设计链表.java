class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class MyLinkedList {
    ListNode head;
    int size;

    public MyLinkedList() {
        // 虚拟头节点
        head = new ListNode();
        size = 0;
    }
    
    public int get(int index) {
        ListNode dummy = head;
        if(index < 0 || index >= size)
            return -1;
        while(index > 0) {
            dummy = dummy.next;
            index--;
        }
        return dummy.next.val;
    }

    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val);
        newHead.next = head.next;
        head.next = newHead;
        size++;
    }
    
    public void addAtTail(int val) {
        ListNode newTail = new ListNode(val);
        ListNode dummy = head;
        while(dummy.next != null) {
            dummy = dummy.next;
        }
        dummy.next = newTail;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index > size || index < 0)
            return;
        if(index == size) {
            addAtTail(val);
            return;
        }
        ListNode dummy = head;
        while(index > 0) {
            dummy = dummy.next;
            index--;
        }
        ListNode tmp = dummy.next;
        dummy.next = new ListNode(val, tmp);
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size)
            return;
        if(index == 0) {
            head = head.next;
            size--;
            return;
        }
        ListNode dummy = head;
        while(index > 0) {
            dummy = dummy.next;
            index--;
        }
        dummy.next = dummy.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
