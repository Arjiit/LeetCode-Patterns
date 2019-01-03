/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        ListNode secondHead = head;
        if (head == null || head.next == null || (head.val == head.next.val && head.next.next == null)) {
            return true;
        }
        
        while (1==1) {
            p = p.next.next;
            if (p == null) {
                secondHead = q;
                break;
            }
            
            if (p.next == null) {
                secondHead = q.next;
                break;
            }
            q = q.next;
        }
        
        ListNode second = reverse(secondHead);
    
        ListNode current = head;
        while (second.next != null) {
            if (current.val != second.val) {
                return false;
            }
            current = current.next;
            second = second.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next;
        
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    
    
    public int getSize(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
}ß