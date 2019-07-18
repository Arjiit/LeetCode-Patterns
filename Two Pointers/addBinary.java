class Solution {
    public String addBinary(String a, String b) {
        /*
        Starting from the last bit, snd appending the result to string and noting the carry
        */
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        
        while(i>=0 || j>= 0) {
            int sum = carry;
            if (j>=0) {
                sum = sum + b.charAt(j) - '0'; // '1' - '0' = 1
             //   System.out.println(sum);
                j--;
            }
            
            if (i >= 0) {
                sum = sum + a.charAt(i) - '0';
              //  System.out.println(sum);
                i--;
            }
            sb.append(sum % 2);
            
            carry = sum/2;
            // System.out.println("carry " + carry);
        }
        
        if (carry != 0) {
            sb.append(carry);
        }
        
        return sb.reverse().toString();
    }
}
