class Solution {

/*
We iterate through the string and keep track of previous Value and operator.
and keep updating the result and previous value.
*/
    public int calculate(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        s = s.trim();
        
        int prevVal = 0;
        char operator = '+';
        int res = 0;
        char[] chs = s.toCharArray();
        int num = 0; //for current number
        int n = s.length();
        for (int i=0; i<chs.length; i++) {
            char c = chs[i];
            
            if (c == ' ') {
                continue;
            }
            
            if (Character.isDigit(c)) {
                num = (int)(c - '0'); // number after operator
                // check to take care of 2 or 3 digit digits
                while (i+1 < n && Character.isDigit(chs[i+1])) {
                    num = num*10 + (int)(chs[i+1] - '0');
                    i++;
                }
                System.out.println("prevVal " + prevVal);
                System.out.println("operator " + operator);
                System.out.println("num " + num);
                
                
                switch(operator) {
                    case '+':
                        res = res + prevVal;
                        prevVal = num;
                        break;
                    
                    case '-':
                        res = res + prevVal;
                        prevVal = -num;
                        break;
                    
                    case '*':
                        prevVal = prevVal*num;
                        break;
                    
                    case '/':
                        prevVal = prevVal/num;
                        break;
                }
                System.out.println("res " + res);
            } else {
                operator = chs[i];
            }
        }
           return res + prevVal; 
    }
}