class Solution {
    public boolean isAdditiveNumber(String num) {
        /*
        we keep the iteration of forming first number from num till num/2, because if
        it's till num, then we will have to get a number that is greater then length of num to be
        additive which is not possible, so we loop through num/2 for first number.
        And for second number at max we see whatever is left after choosing l1.
        */
        if (num == null || num.length() < 3) {
            return false;
        }
        String s = num;
        int n = num.length();
        for (int l1= 1; l1 <= n/2; l1++) {
            if (l1 > 1 && s.charAt(0) == '0') 
                break;
            
            for (int l2=1; l2 < s.length() - l1; l2++) {
                if (l2 > 1 && s.charAt(l1) == '0') break;
                
                Long num1 = Long.valueOf(s.substring(0,l1));
                Long num2 = Long.valueOf(s.substring(l1, l1+l2));
                // s.substring(n) gets substring from nth to end of the string
                // because we want to check if the sring contains sum of l1 and l2 at l1+l2 
                // index onwards, so we take the substring of s from l1+l2 till the length of s.
                if (isAdditive(s.substring(l1 + l2), num1, num2)) {
                    return true;
                }
            }
        }
        
        return false;
    }
            
    private boolean isAdditive(String s, Long num1, Long num2) {
        if(s.isEmpty()) {
            return true;
        }
        String num3str = String.valueOf(num1+num2);
        System.out.println("num1 " + num1);
        System.out.println("num2 " + num2);
        System.out.println("s " + s);
        System.out.println("num3str " + num3str);
        if (!s.startsWith(num3str)) {
            return false;
        }
        
        return isAdditive(s.substring(num3str.length()), num2, num1 + num2);
    }
    
}