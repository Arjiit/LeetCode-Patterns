class Solution {
    public String toHex(int num) {
        /*
        int has 32 bits, and we check 4 bits at a time, so we will loop 8 times.
        */
        if (num ==0) {
            return "" + "0";
        }
        
        String map = "0123456789abcdef";
        String res = "";
        for (int i=0; i<8; i++) {
            int ans = num&15; // 15 is 1111b , so we get hexadecimal by &
            char c = map.charAt(ans);
            res = c + res; // add our result
            num = num >> 4; // right shift by 4, to check the next 4
        }
        String ret = "";
        for (int i=0; i<res.length(); i++) { // we strip off any leading 0's.
            if (res.charAt(i) == '0') {
                continue;
            } else {
                ret = res.substring(i, res.length());
                break;
            }
        }
        return ret;
    }
}