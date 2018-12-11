class Solution {
    public boolean isPalindrome(String s) {

	int leftptr = 0;
        int rightptr = s.length()-1;
        
        while(leftptr<rightptr){
				
            while(leftptr<s.length() && !Character.isLetterOrDigit(s.charAt(leftptr))){
                leftptr++;
            }
            while(rightptr>=0 && !Character.isLetterOrDigit(s.charAt(rightptr))){
                rightptr--;
            }
            
            if(leftptr<rightptr && Character.toLowerCase(s.charAt(leftptr))!=Character.toLowerCase(s.charAt(rightptr)))
                return false;
            
            leftptr++;
            rightptr--;
        }
        
        return true;
    }
    }
