class Solution {
    /*
    Same as largest rectangle in a histogram question except we have to go through the matrix and 
    keep updating our array and for each new array we find maximum area of rectangle in histogram.
    While updating the array, If in new element in matrix position is 0, we add 0 to the array 
    position, otherwise we add the number to the element in the array's previous position.

    T.C. -> O(cols*rows), Space -> O(cols) 
    */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[] arr = new int[matrix[0].length];
        for (int i=0; i< arr.length; i++) {
                arr[i] = 0;
        }
        int j = 0;
        int maxArea = 0;
        int area = 0;
        Stack<Integer> s = new Stack<>();
        while(j < matrix.length){
        for (int i=0; i<matrix[0].length; i++) {
            if (matrix[j][i] == '0') {
                arr[i] = 0;
            } else {
                arr[i] = arr[i] + Character.getNumericValue(matrix[j][i]);
            }
        }
            j++;
            int k=0;
            while (k < arr.length) {
                if(s.isEmpty() || arr[s.peek()] <= arr[k]) {
                    s.push(k);
                    k++;
                } else {
                    int top = s.pop();
                    if (s.isEmpty()) {
                        area = k*arr[top];
                        
                    } else {
                            area = arr[top]*(k - s.peek() - 1);
                    }
                    if (area > maxArea) {
                        maxArea = area;
                    }
                     
                }
                
            }
            while(!s.isEmpty()) {
                int top = s.pop();
                 System.out.println(top);
                if (s.isEmpty()) {
                    area = k*arr[top];
                } else {
                    area = arr[top]*(k - s.peek() - 1);
                }
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }
}