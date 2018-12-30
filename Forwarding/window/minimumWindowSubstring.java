class Solution {
    public String minWindow(String s, String t) {
   
        HashMap<Character,Integer> hm = new HashMap<Character, Integer>();
        
        
        for (int i=0; i<t.length(); i++) {
            if (hm.containsKey(t.charAt(i))) {
                hm.put(t.charAt(i), hm.get(t.charAt(i)) + 1);
            }    else {
                hm.put(t.charAt(i), 1);
            }
        }

        int number = 0;
        int uniqueChar = hm.size();
        int i =0;
        int j =0;
        int min = Integer.MAX_VALUE;
        int start = 0;
        
        while (j < s.length()) {
            
            if (number < uniqueChar) {
                char c = s.charAt(j);
                j++;
                if (!hm.containsKey(c)) {
                    continue;
                } else {
                    int freq = hm.get(c);
                    if (freq == 1) {
                        number++;
                    }
                    hm.put(c,freq-1);
                }
            }
            
            while(number == uniqueChar) {
                if (min > j-i) {
                    min = j - i;
                    start = i;
                }
                
                char c = s.charAt(i);
                i++;
                if (hm.containsKey(c)) {
                    int freq = hm.get(c);
                    if (freq == 0) {
                        number--;
                    }
                    hm.put(c, freq+1);
                } else {
                    continue;
                }
                
            }
            
            
        }
        
        if (min == Integer.MAX_VALUE) {
            return "";
            
        } else {
            return s.substring(start, start+min);
        }
        }
}