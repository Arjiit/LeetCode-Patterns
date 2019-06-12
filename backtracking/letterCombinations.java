class Solution {
    public List<String> letterCombinations(String digits) {
        String[] str = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        getList(digits, str, res, "", 0);
        return res;
    }
    
    public void getList(String digits, String[] str, List<String> res, String temp, int start) {
        if (start == digits.length()) {
            res.add(temp);
            return;
        }
        
        String first = str[Character.getNumericValue(digits.charAt(start))];
        for (int i=0; i<first.length(); i++) {
            temp = temp + first.charAt(i);
            System.out.println(temp);
            getList(digits, str, res, temp, start + 1); //start + 1 as after appending the letter for 
            // first number, we have to append all the letters for the second number
            // backtrack to remove the second element and append further letters.
            temp = temp.substring(0, temp.length() - 1);
        }
    }
}