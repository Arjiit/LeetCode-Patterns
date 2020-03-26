class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       /*
       We use Double ended queue to maintain the greatest element at the front 
       of the queue. And smaller elements behind it.
       If the element is not in the sliding window, we remove it from the queue.
       1. We check if the element at the front of deque is in the window or not.
       2. We check if the element at the end of deque is less than current element.
       3. we add the current element to the end of the deque to maintain the order.
       */
    
        if (nums == null || nums.length == 0 ||nums.length < k) return new int[0];
        
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int i = 0;
        while(i < nums.length) { 
            // from the front of deque
            if (!dq.isEmpty() && dq.peekFirst() == i - k) { // storing indexes
                dq.pollFirst();
            }
            // from the end of deque, keep removing till element is smaller than current element
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            
            if (i >= k-1) {
                res[i-k+1] = nums[dq.peekFirst()]; // max element will be at top
            }
            i++;
        }
        return res;
    }
}