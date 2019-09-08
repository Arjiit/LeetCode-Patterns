class LRUCache {
    /*
    For fast lookups - Hashtable
    For fast removals - doubly linked list
    Space intensive but we get fast operations.
    We use O(1) for both get and put methods
    Space - O(n), n is capacity of the cache
    */
    
    class Node {
      int key;
        int val;
        Node next;
        Node prev;
        // no constructor
    }
    
    private Map<Integer, Node> hashtable = new HashMap<Integer, Node>();
    private Node head;
    private Node tail;
    private int totalItemsInCache;
    private int capacity;
    
    
    public LRUCache(int capacity) {
        
        totalItemsInCache = 0;
        this.capacity = capacity;
        
        // initializing dummy head of the cache
        head = new Node();
        head.prev = null;
        
        // intitalizing dummy tail of the cache
        tail = new Node();
        tail.next = null;
        
        // connecting head and tail initially
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
       Node n = hashtable.get(key);
        boolean itemFoundInCache;
        if (n != null) {
             itemFoundInCache = true;
        } else {
             itemFoundInCache = false;
        }
        
        if (!itemFoundInCache) {
            return -1;
        }
        // since this element is accessed, we need to move to front of linkedList
        moveToHead(n);
        
        return n.val;
    }
    /*
    we will add the element if it's not there, else if it 
    is there, we will update and move it to front
    */
    
    public void put(int key, int value) {
        
        Node n = hashtable.get(key);
        boolean itemFoundInCache;
        if (n != null) {
             itemFoundInCache = true;
        } else {
             itemFoundInCache = false;
        }
        
        if (!itemFoundInCache) {
            // we will create a node
            Node new_node = new Node();
            new_node.key = key;
            new_node.val = value;
            // adding the node to hashmap and linkedlist
            hashtable.put(key, new_node);
            addNode(new_node);
            
            totalItemsInCache++;
            
            if (totalItemsInCache > capacity) {
                removeLRU();
            }
            
        } else {
            // we will update and move it to front
            n.val = value;
            moveToHead(n);
        }
    }
    
    // removing least used from cache
    private void removeLRU() {
        Node tail_node = popTail();
        hashtable.remove(tail_node.key);
        --totalItemsInCache;
    }
    
    // last node in the DLL
    private Node popTail() {
        Node nodeRemoved = tail.prev; // last node will point to tail, so we want tail's previous
        removeNode(nodeRemoved);
        return nodeRemoved;
    }
    
    private void removeNode(Node node) {
        Node savePrev = node.prev;
        Node saveNext = node.next;
        
        savePrev.next = saveNext;
        saveNext.prev = savePrev;
        
        
    }
    
    private void moveToHead(Node node) {
        // for moving to head, we would just need to remove the node and add it
        // since we are already adding to front
        removeNode(node);
        addNode(node);
    }
    
    private void addNode(Node node) {
        // we want to add to front
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */