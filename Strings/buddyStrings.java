class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        HashSet<Character> setA = new HashSet<>();
        HashSet<Character> setB = new HashSet<>();
        boolean dupA = false;
        boolean dupB = false;
        List<Integer> mismatch = new ArrayList<>();
        for (int i=0; i<A.length(); i++) {
            if (setA.contains(A.charAt(i))) {
                dupA = true;
            }
            if (setB.contains(B.charAt(i))) {
                dupB = true;
            }
            
            if(A.charAt(i) != B.charAt(i)) {
                mismatch.add(i);
            }
            setA.add(A.charAt(i));
            setB.add(B.charAt(i)); 
        }
        if (mismatch.size() == 2) {
            if ((A.charAt(mismatch.get(0)) == B.charAt(mismatch.get(1)))&& (A.charAt(mismatch.get(1)) == B.charAt(mismatch.get(0)))) {
                return true;
            }
        }
        if (dupA && dupB && A.equals(B)) {
            return true;
        }
      return false;  
    }
}