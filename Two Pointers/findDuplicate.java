class Solution {
    public int findDuplicate(int[] nums) {
        /*
        If we see this array as a list that can be traversed then, it can be traversed infinetley, since it has a duplicate. Hence, we can also say it has a cycle. Therefore we can use Floyd's Cycle Detection here too. (which is used to detect cycle in Linked List)
        So, we find intersection of two pointers and then start one pointer from start and
        other one from intersection and move 1 eachtime till values are equal.
        
        We need second loop because in first loop both pointers might end up at the same index and hence we will get a number which might not be a duplicate. The first loop just gives us the intersection of the indexes, the second loop returns the index to the duplicate number.
        */
       int t = nums[0]; // tortoise pointer that moves 1 everytime
        int h = nums[0]; // hare pointer that moves twice
        
        do {
            t = nums[t];
            h = nums[nums[h]];
        } while(t != h);// this will give us interesection of two pointers
        
        int ptr1 = nums[0];
        int ptr2 = h;
        // now start one pointer from starting and other from intersection
        // move them one at a time, till both the pointers have same value
        while(ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        
        return ptr1;
    }
}