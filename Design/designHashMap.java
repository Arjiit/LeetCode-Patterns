class MyHashMap {
/*
Since max operations is specified as 10000, we will create an array of that size.
In case of collisions - using linear probing - increase hashkey by 1 and then find mod and new place in array.
Using quadratic probing - use hashKey = (key + j*j)%arr.length, increasing j and finding new places in array.
Similar probing while getting and removing elements from hashmap.
*/
class Node {
    int key;
    int value;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
    Node[] arr;
    /** Initialize your data structure here. */
    public MyHashMap() {
        arr = new Node[10001];
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashKey = key%arr.length;
            while (arr[hashKey] != null && arr[hashKey].key != key) {
                hashKey++;
                hashKey = hashKey%arr.length;
            }
            if (arr[hashKey] == null) {
                arr[hashKey] = new Node(key, value);
            } else {
                arr[hashKey].value = value;
            }
        }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashKey = key%arr.length;
        
            while (arr[hashKey] != null && arr[hashKey].key != key) {
                hashKey++;
                hashKey = hashKey%arr.length;
            }
        if (arr[hashKey] == null) {
            return -1;
        }
        return arr[hashKey].value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashKey = key%arr.length;
            while (arr[hashKey] != null && arr[hashKey].key != key) {
                hashKey++;
                hashKey = hashKey%arr.length;
            }
        if (arr[hashKey] == null) {
            return;
        }
        arr[hashKey].key = -1;
        arr[hashKey].value = -1;
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */