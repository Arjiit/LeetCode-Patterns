class MyStack {
    /*
    Either we can make push expensive or pop expensive depending upon how we decide to
    use 2 queues. Here push is O(1) and pop is O(n).
    */
    /** Initialize your data structure here. */
    Queue<Integer> q1;
    Queue<Integer> q2;
    private int top;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
            q1.add(x);
            top = x; // O(1) operation
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(q1.size() > 1) {
            top = q1.remove();
            q2.add(top);
        }
        int ans = q1.remove(); //noting the last element
        Queue<Integer> temp = q1;
        q1 = q2; // swapping both queues
        q2 = temp;
        return ans;
        }
    
    /** Get the top element. */
    public int top() {
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        if (q1.isEmpty()) {
            return true;
        }
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */