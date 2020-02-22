class Solution {
    public String multiply(String num1, String num2) {
    /*
    Multiplying strings as normal multiplication and storing the sum and carry in an array posiiton.
    */
        int m = num1.length();
        int n = num2.length();
        int[] val = new int[m+n];
        for(int i=m-1; i>= 0; i--) {
            for (int j=n-1; j>=0; j--) {
                int sum = (num1.charAt(i) - '0')*(num2.charAt(j) - '0') + val[i+j+1];
                val[i+j] = val[i+j] + sum/10;
                val[i+j+1] = sum%10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<val.length; i++){
            if (sb.length() != 0 || val[i] != 0){
                sb.append(val[i]);
            }
        }
        return sb.length() == 0 ? "0": sb.toString();
    }
}