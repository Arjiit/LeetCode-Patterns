
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode list1 = new ListNode(0);
        ListNode list2 = new ListNode(0);
        
        ListNode dummy1 = list1;
        ListNode dummy2 = list2;
        
        ListNode cur = head;
        
        while(cur != null) {
            if (cur.val < x) {
                list1.next = cur;
                list1 = list1.next;
            } else {
                list2.next = cur;
                list2 = list2.next;
                
            }
            cur = cur.next;
        }
        list2.next = null;
        list1.next = dummy2.next;
    
        return dummy1.next;
    }
}