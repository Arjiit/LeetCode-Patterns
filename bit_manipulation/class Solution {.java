class Solution {
    public int bitwiseComplement(int N) {
        // handy method to convert integer to decimal format
        String intBinary = Integer.toString(N,2);
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i< intBinary.length(); i++) {
            if(intBinary.charAt(i) == '0') {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }
        String ans = sb.toString();
        int ansBase10 = Integer.parseInt(ans,2);
        
        return ansBase10;
    }
}

// to get complement using bit manipulation
// xor the digits with 1

class Solution {
    public int bitwiseComplement(int N) {
               // xor the bits with all set bits
        String decimalN = Integer.toString(N,2);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<decimalN.length(); i++) {
            sb.append(Character.getNumericValue(decimalN.charAt(i))^1);
        }
        String ans = sb.toString();
        int decimalAns = Integer.parseInt(ans,2);
        return decimalAns; 
    }
}