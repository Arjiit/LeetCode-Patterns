/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        int listSize = size(head);
        
        int optimizedK = k%listSize; // getting the effective rotations needed
        
        if (optimizedK == 0) {
            return head;
        }
        
        
        int reach = 0;
        ListNode p = head;
        while(p != null) {
            if (reach == (size(head) - optimizedK) -1) { // moving to a position in a list before where it needs to be rotated
                break;
            }
            reach++;
            p = p.next;
        }
        
        ListNode newHead = p.next;
        
        p.next = null; 
        
        ListNode cur = newHead;
        
      
        
        while (cur.next != null) {
            cur = cur.next;
        }
        
        cur.next = head;
        
        
        return newHead;
}
        private int size(ListNode curr){
        int i = 0;
        while(curr != null){
            i++;
            curr = curr.next;
        }
        return i;
    }
}