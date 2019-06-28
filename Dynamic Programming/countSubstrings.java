class Solution {
    /*
    A -> one character is always a palindrome.
    AA -> two character is palindrome if they are equal.
    ABA -> 3 characters is a palindrome as long as s[i] == s[j] (j - i <= 2).
    ABBA -> 4 characters is a plaindrome as long as s[i] == s[j] and inner one is palindrome.
    We can fill all i==j cells first as they are always a palindrome, then expand and
    fill the 3 letters one i.e. (j - i <= 2) and then fill the rest ensuring j >= i.
    */
public int countSubstrings(String s) {
    int n = s.length();
    int res = 0;
    boolean[][] dp = new boolean[n][n];
    for (int i = n - 1; i >= 0; i--) {
        for (int j = i; j < n; j++) {
            dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
            if(dp[i][j]) ++res;
        }
    }
    return res;
}
}