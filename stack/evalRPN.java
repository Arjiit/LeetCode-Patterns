import java.math.*;
class Solution {
    public int evalRPN(String[] tokens) {
        /*
        we will iterate throught the array - if it is a number we will push it to stack
        if it is a operator we will remove two elements from the stack and push the result
        back to stack.
        */
        Stack<Integer> s = new Stack<>();
        for(String t: tokens){
            if(t.equals("+")) {
                s.push(s.pop() + s.pop());
            }else if(t.equals("-")){
                s.push(-1 * s.pop() + s.pop());
            }else if(t.equals("/")){
                int b = s.pop();
                int a = s.pop();
                s.push( a / b );
            }else if(t.equals("*")) {
                s.push(s.pop() * s.pop());
            }else {
                s.push(Integer.parseInt(t));
            }
        }
        
        return s.pop();
    }
}