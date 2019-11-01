class MyHashMap {
class HashArr {
    int key;
    int val;
    public HashArr(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
    HashArr[] h;
    int size = 1000000;
    /** Initialize your data structure here. */
    public MyHashMap() {
        h = new HashArr[size];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashKey = key%size;
        if (h[hashKey] == null) {
            HashArr h_new = new HashArr(hashKey, value);
            h[hashKey] = h_new;
        } else {
            h[hashKey].key = key;
            h[hashKey].val = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashKey = key%size;
        if (h[hashKey] != null) {
            return h[hashKey].val;
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashKey = key%size;
        if (h[hashKey] != null) {
            h[hashKey] = null;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */