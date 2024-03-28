class LRUCache {

    public class ListNode {
        ListNode pre;
        ListNode nxt;
        int key;
        int val;
        ListNode() {}
        ListNode(int key, int val) {this.key = key; this.val = val;}
        
    }
    Map<Integer, ListNode> map = new HashMap<>();
    int capacity, size;
    ListNode head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        // 伪头部和伪尾部
        head = new ListNode();
        tail = new ListNode();
        head.nxt = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            // 不存在返回-1
            return -1;
        } else {
            // 更新为最近使用过 并返回
            moveToHead(map.get(key));

            return map.get(key).val;
        }
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)) {
            // 原本不存在map中
            ListNode newNode = new ListNode(key ,value);
            addToHead(newNode);
            map.put(key, newNode);
            size++;
            // 判断是否超过capacity
            if(size > capacity) {
                map.remove(tail.pre.key);
                removeTail();
                size--;
            }
        } else {
            // 原本存在，就要更新
            map.get(key).val = value;
            // 同时更新链表
            moveToHead(map.get(key));
        }
    }

    public void addToHead(ListNode node) {
        node.nxt = head.nxt;
        node.pre = head;
        head.nxt = node;
        node.nxt.pre = node;
    }

    public void removeTail() {
        tail.pre = tail.pre.pre;
        tail.pre.nxt = tail;
    }

    public void moveToHead(ListNode node) {
        node.pre.nxt = node.nxt;
        node.nxt.pre = node.pre;
        node.nxt = head.nxt;
        head.nxt = node;
        node.pre = head;
        node.nxt.pre = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
