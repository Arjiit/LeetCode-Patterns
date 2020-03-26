class LFUCache {
    class Node {
        int key, val;
        Node prev, next;
        int cnt;
        public Node(int k, int v) {
            this.key = k;
            this.val = v;
            cnt = 1;
        }
    }
    
    class DLL {
        Node head, tail;
        int len;
        public DLL() {
            head = new Node(0,0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            len = 0; // since no node in DLL
        }
    
    public void addHead(Node node) {
        Node next = head.next; // save next address
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
        map.put(node.key, node);
        len++;
    }
    
    public void remove(Node node) {
        Node prev = node.prev; // save prev address
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        map.remove(node.key);
        len--;
    }
    
    public void removeTail() {
        Node prevTail = tail.prev;
        remove(prevTail);
    }
    }
    Map<Integer, DLL> freq;
    Map<Integer, Node> map; // for (key, node) pair
    int capacity, size;
    int maxFreq;
    public LFUCache(int capacity) {
        freq = new HashMap<>();
        map = new HashMap<>();
        this.capacity = capacity;
        size = 0;
        maxFreq = 0;
    }
    
    public int get(int key) {
        if (map.get(key) == null) return -1;
        Node node = map.get(key);
        int prevFreq = node.cnt;
        DLL prevList = freq.get(prevFreq);
        prevList.remove(node);
        int curFreq = prevFreq + 1;
        maxFreq = Math.max(maxFreq, curFreq);
        DLL curList = freq.getOrDefault(curFreq, new DLL()); // since there may not be a DLL on that frequency
        node.cnt++;
        curList.addHead(node);
        freq.put(prevFreq, prevList); // updating prevfreq list and curfreq list
        freq.put(curFreq, curList);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return; // we can't put
        if (map.get(key) != null) { // meaning a node exists
            map.get(key).val = value; //update its value
            get(key); // since we are accessing it, we have to increase it's freq
            return;
        }
        Node newNode = new Node(key, value);
        DLL curList = freq.getOrDefault(1, new DLL()); // get the DLL corresponding to freq 1 or create a new one
        curList.addHead(newNode);
        size++;
        if (size > capacity) {
            if (curList.len > 1) { // if freq 1 list has nodes in it, remove last one
                curList.removeTail();
            } else {
                for (int i=2; i<=maxFreq; i++) {
                    if (freq.get(i) != null && freq.get(i).len > 0) {
                        freq.get(i).removeTail();
                        break;
                    }
                }
            }
            size--;
        }
        freq.put(1, curList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */