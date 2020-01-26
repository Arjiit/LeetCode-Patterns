class Solution {
    public String freqAlphabets(String s) {
        int len = s.length()-1;
        StringBuilder sb = new StringBuilder();
        while(len >= 0) {
            if (s.charAt(len) =='#') {
                StringBuilder num = new StringBuilder();
                num.append(s.charAt(len - 1));
                num.append(s.charAt(len - 2));
                num.reverse();
               
                char c = (char)(Integer.parseInt(num.toString()) + 'a' - 1);
                 System.out.println(c);
                sb.append(c);
                len = len - 2;
            } else {
                char c = (char) (Integer.parseInt(String.valueOf(s.charAt(len))) + 'a' - 1);
                sb.append(c);
            }
            len--;
        }
        return sb.reverse().toString();
    }
}