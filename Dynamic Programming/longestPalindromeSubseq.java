class Solution {
    /*
    Larger problem can be broken down into subproblems, hence this can be solved using DP.
    subproblem - to find longest palindrome subsequence for each pair in the strings
    using two pointers i and j with i marking the start and j marking the end.
    case 1: single character a/b/c etc - longest palindromic subsequence would be 1.
    case 2: aba, character at i == j, then longest palindromic subsequence would be 2 +
    longest palindromic subsequence of interior string i.e. dp[i+1][j-1]
    case 3: abbc, character at i != j, then longest palindromic subsequence would be 
    max of longest palindromic sequence of interior strings i.e. max(dp[i+1][j], dp[i][j-1]).
    */
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        
        for (int i=0; i< s.length(); i++) {
            dp[i][i] = 1;
        }
        
        for (int i=s.length() - 1; i>=0; i--) {
            for (int j=i+1; j< s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}