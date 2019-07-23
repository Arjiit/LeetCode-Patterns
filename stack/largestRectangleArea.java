class Solution {
    public int largestRectangleArea(int[] heights) {
    /*
    We maintain a stack of indexes of the array.
    If stack is empty or value at index of stack is less than or equal to value at      current index, push this into stack. Otherwise keep removing values from stack till value at index at top of stack is less than value at current index. While removing value from stack calculate area if stack is empty it means that till this point value just removed has to be smallest elementso area = input[top] * i. If stack is not empty then this value at index top is less than or equal to everything from stack top + 1 till i. So area will area = input[top] * (i - stack.peek() - 1);
    
    T.C. -> O(n), S.C -> O(n)
    */
        Stack<Integer> s = new Stack<Integer>();
        
        int maxArea = 0;
        int area = 0;
        int i=0;
        while(i < heights.length) {
            if (s.isEmpty() || heights[s.peek()] <= heights[i]) {
                s.push(i);
                i++;
            } else {
                int top = s.pop();
                
                if (s.isEmpty()) {
                    area = heights[top]*i;
                } else {
                    area = heights[top]*(i-s.peek() - 1);
                }
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        
        while(!s.isEmpty()) {
            int top = s.pop();
            
            if (s.isEmpty()) {
                area = heights[top]*i;
            } else {
                area = heights[top]*(i - s.peek() - 1);
            }
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}