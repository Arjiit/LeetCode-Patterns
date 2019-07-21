class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> output = new ArrayList<>();
        removeHelper(s, output, 0, 0, '(', ')');
        return output;
    }

    /*
    We keep the openParen as '(' and closed as ')', we try to find an extra closed ')' that would make an invalid parenthesis
    and we will remove it by skipping it and then keep checking for invalid parenthesis with iStart value as next i value and
    jStart value as the index of j we removed the invalid parenthesis from. If we are done 'i' iterating over the string, we 
    reverse the string and now we check for invalid parenthesis with an extra '(' and so, we call the same code recursively.
    once we are done, so we reverse back to original valid string and add to result. The control goes back to return statement
    to find the next ')' since j goes from jStart to i.
    The program only looks for valid answers which in this case if it is 'k', then time complexity would be O(nk) where n is
    the length of the string.
    */

    public void removeHelper(String s, List<String> output, int iStart, int jStart, char openParen, char closedParen) {
        int numOpenParen = 0, numClosedParen = 0;
        for (int i = iStart; i < s.length(); i++) {
            if (s.charAt(i) == openParen) numOpenParen++;
            if (s.charAt(i) == closedParen) numClosedParen++;
            if (numClosedParen > numOpenParen) { // We have an extra closed paren we need to remove
                for (int j = jStart; j <= i; j++) // Try removing one at each position, skipping duplicates
                    if (s.charAt(j) == closedParen && (j == jStart || s.charAt(j - 1) != closedParen))
                    // Recursion: iStart = i since we now have valid # closed parenthesis thru i. jStart = j prevents duplicates
                        removeHelper(s.substring(0, j) + s.substring(j + 1, s.length()), output, i, j, openParen, closedParen);
                return; // Stop here. The recursive calls handle the rest of the string.
            }
        }
        // No invalid closed parenthesis detected. Now check opposite direction, or reverse back to original direction.
        String reversed = new StringBuilder(s).reverse().toString();
        if (openParen == '(') // to check wheteher we have just checked for the original version of the string or reverse.
            removeHelper(reversed, output, 0, 0, ')','(');
        else
            output.add(reversed); // we have checked both the original and reversed version.
    }
}