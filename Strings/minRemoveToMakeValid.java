class Solution {
    public String minRemoveToMakeValid(String s) {
        /*
        Use hashset to store locations of each imbalanced parenthesis.
        Use stack to match - if ) and stack empty then need to delete '(' and if stack not empty then need to delete.
        */
        
        List<Integer> open = new ArrayList<>();
        List<Integer> closed = new ArrayList<>();
        HashSet<Integer> del = new HashSet<>();
        Stack<Integer> st = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else if (s.charAt(i) == ')') {
                if (!st.isEmpty()) {
                    st.pop();
                } else {
                    del.add(i);
                }
            }
        }
        while(!st.isEmpty()) {
            del.add(st.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            if(del.contains(i)) {
                continue;
            } else {
                sb.append(s.charAt(i));
            }
        }
       return sb.toString(); 
    }
}