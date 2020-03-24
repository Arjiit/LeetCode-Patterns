/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

// O(N) time, O(N) space
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        // mapping original node to its clone
        HashMap<Node, Node> hm = new HashMap<>();
        
        // giving all nodes their clone in the mapping
        Node cur = head;
        while(cur != null) {
            hm.put(cur, new Node(cur.val)); //(node, node_clone)
            cur = cur.next;
        }
        
        //resetting cur pointer to head of the original list
        // giving all clones their next and random ptr
        cur = head;
        while(cur != null) {
            hm.get(cur).next = hm.get(cur.next);
            hm.get(cur).random = hm.get(cur.random);
            cur = cur.next;
        }
        return hm.get(head);
    }
}

// O(N) time, O(1) space

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        Node cur = head;
        Node next = null;
        
        // 1st pass, just connect original nodes to its clone
        while(cur != null) {
            next = cur.next; //storing next value of original node, so that we don't lose it
            Node copyNode = new Node(cur.val);
            cur.next = copyNode;
            copyNode.next = next;
            // advancing to next node in original list
            cur = next;  
        }
        // 2nd pass, assign clone its random mapping
        cur = head;
        while(cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next; // since we want random's clone
            }
            cur = cur.next.next;
        }
        //3rd pass, removing the next value of original nodes
        cur = head;
        Node dummyHead = new Node(0);
        Node cloneListTail = dummyHead;
        Node copy = null;
        while(cur != null) {
            next = cur.next.next; //next in the original node
            // saving cur's clone
            copy = cur.next; 
            // appending copy to final list tail
            cloneListTail.next = copy;
            cloneListTail = copy;
            
            cur.next = next; // restoring original cur's next value
            
            cur = next; // advancing curr to next in the original node
            
        }
        return dummyHead.next;
    }
}