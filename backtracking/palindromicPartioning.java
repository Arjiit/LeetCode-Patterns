class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, new ArrayList<>(), res, 0);
        return res;
    }
    /*
    we use i= start as starting as later we can increase i and take different
    substring pairs from the string from (start, i) and check if they are 
    palindrome or not. Also, we use start to keep track of the string traversed.
    if start reaches the end, we append the temporary palindormic string to result.
    */
    
    public void backtrack(String s, List<String> tempList, List<List<String>> res, int start) {
        
        if(start == s.length()) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        
        for (int i=start; i<s.length(); i++) {
            if(isPalindrome(s, start, i)){
                tempList.add(s.substring(start, i+1));
                backtrack(s,tempList, res, i+1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String str, int low, int high) {       
        while (low < high) {
            if (str.charAt(low) != str.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
}
}