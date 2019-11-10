class Solution {
    public String customSortString(String S, String T) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> hs = new HashSet<>();
        for (int i=0; i<T.length(); i++) {
            hs.add(T.charAt(i));
        }
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i=0; i<T.length(); i++) {
            if (!hm.containsKey(T.charAt(i))) {
                hm.put(T.charAt(i), 1);
            } else {
                hm.put(T.charAt(i), hm.get(T.charAt(i)) + 1);
            }
        }
        StringBuilder rest = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();
        for (int i=0; i<S.length(); i++) {
            if (hs.contains(S.charAt(i))) {
                for (int j=0; j<hm.get(S.charAt(i)); j++) {
                    sb.append(S.charAt(i));
                }
                seen.add(S.charAt(i));
            } 
        }
        
        for (int i=0; i<T.length(); i++) {
            if (!seen.contains(T.charAt(i))) {
                sb.append(T.charAt(i));
            }
        }
        return sb.toString();
    }
}