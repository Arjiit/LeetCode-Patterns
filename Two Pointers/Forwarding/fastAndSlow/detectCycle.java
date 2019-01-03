public class Solution {
            public ListNode detectCycle(ListNode head) {
                ListNode slow = head;
                ListNode fast = head;

                // after you detect a cycle
                // start a pointer from head
                // move by one until both new pointer and slow pointer meet
        
                while (fast!=null && fast.next!=null){
                    fast = fast.next.next;
                    slow = slow.next;
                    
                    if (fast == slow){
                        ListNode slow2 = head; 
                        while (slow2 != slow){
                            slow = slow.next;
                            slow2 = slow2.next;
                        }
                        return slow;
                    }
                }
                return null;
            }
        }