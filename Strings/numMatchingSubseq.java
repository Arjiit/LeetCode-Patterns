class Solution {
    int count = 0;
    public int numMatchingSubseq(String S, String[] words) {
        int maxLen = 0;
        HashMap<String, Integer> hs = new HashMap<>();
        for (String w: words) {
            if (!hs.containsKey(w)) {
                hs.put(w, 1);
            } else {
                hs.put(w, hs.get(w)+ 1);
            }
            maxLen = Math.max(w.length(),maxLen);
        }
        int count = 0;        
        for(Map.Entry<String, Integer> entry: hs.entrySet()) {
            if (isSubsequence(entry.getKey(), S, entry.getKey().length(), S.length())) {
                System.out.println(entry.getKey() + "yes");
                count += entry.getValue();
            }
        }
        return count;
    }
    
    public boolean isSubsequence(String str1, String str2, int m, int n){
        int j = 0;
        for (int i=0; i<n && j <m; i++) {
            if(str1.charAt(j) == str2.charAt(i)) {
                j++;
            }
        }
        return (j == m);
    }
}