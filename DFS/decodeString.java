class Solution {
    public String decodeString(String s) {

        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        
        StringBuilder sb = new StringBuilder();
        
        int n = s.length();
        
        for (int i=0; i<n; i++) {
            char c = s.charAt(i);
            // storing the number in numStack
            if (Character.isDigit(c)) {
                int num = c - '0';
                // to take care of more than 1 digit numbers
                while(i + 1 < n && Character.isDigit(s.charAt(i+1))) {
                    num = num*10 + s.charAt(i+1) - '0';
                    i++;
                }
                numStack.push(num);
            //
            } else if (c == '[') {
                // push the already formed string to stack, so that next time
                // we pop, we take this string into consideration
                strStack.push(sb.toString());
                // reset the stringbuilder
                sb = new StringBuilder();
            } else if (c == ']') {
                // pop the already formed string and number from the stack
                StringBuilder tmp = new StringBuilder(strStack.pop());
                int repeatedTimes = numStack.pop();
                for (int j=0; j<repeatedTimes; j++) {
                    tmp.append(sb); //append to already popped string
                }
                sb = tmp;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}