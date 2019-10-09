class Solution {
    /*
    O(3^n) solution,
    if the characters don't match in the strings, we have 3 options.
    Hence 3 recursivve calls.
    */
    public int minDistance(String word1, String word2) {
        return getCount(word1, word2, word1.length()-1, word2.length() -1);
    }
    
    public int getCount(String word1, String word2, int w1, int w2) {
        if (word1.length() == 0) {
            return word2.length();
        }
        
        if (word2.length() == 0) {
            return word1.length();
        }

        if ( w1 >0 && w2 >0 && word1.charAt(w1) == word2.charAt(w2)) {
          return getCount(word1, word2, w1-1, w2-1);
        } 
        
        return 1 + Math.min(getCount(word1, word2, w1, w2-1), 
                            Math.min(getCount(word1,word2, w1-1,w2), getCount(word1,word2, w1-1,w2-1)));
    }
}

/*
Converting the recursive definition to recursion with results in DP table.
*/

class Solution {
    public int minDistance(Stirng word1, String word2) {
        int[][] distance = new int[word1.length][word2.length];
        for (int[] rows: distance) {
            Arrays.fill(rows, -1);
        }

        return computeDistance(word1, word1.length() -1, word2, word2.length() -1, distance);
    }


    public int computeDistance(String word1, int m, String word2, int n, int[][] distance) {
        /*
            If the substring of A is from 0 to 0 we have the empty string "" versus whatever
            B is. Therefore the edit distance between the two will be the length of B which
            is n + 1
        */
        if (m < 0) {
            return n+1;
        }

        if (n < 0) {
            return m+1;
        }
        if (distance[m][n] == -1) {
            if (word1.charAt(m) == word2.charAt(n)) {
                distance[m][n] = distance[m-1][n-1];
            } else {
                int replace = computeDistance(word1, m-1, word2, n-1, distance);
                int delete = computeDistance(word1, m-1, word2, n, distance);
                int insert = computeDistance(word1, m, word2, n-1, distance);

                distance[m][n] = 1 + Math.min(replace, Math.min(delete, insert));
            }
        }
        return distance[m][n];
    }
}


/* creating a dp table representing two strings.
Each cell represents a subproblem, i.e. edit distance for (0,i) and (0,j) substirng.
with an extra row and col for space.
if characters match (char at i-1 and at j-1)then take value from dp[i-1][j-1].
if they don't match take value as 1 + Minimum((value at i-1,j-1), replace, we perform transformation of everything before the mismatch.
(value at i, j-1) i.e insert, we perform transformation of original string (0,i) to substring(0,j-1) and add element at j. cost = 1 + dp[i][j-1]
(value at i-1, j) i.e. delete, we delete element in original string at i (0,i-1) and transform to final string (0,j). cost = 1 + dp[i-1][j].

*/
class Solution {
    public int minDistance(String word1, String word2) {
       int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        
        for (int i=0; i<dp[0].length; i++) {
            dp[0][i] = i;
        }
        
        for (int j=0; j< dp.length; j++) {
            dp[j][0] = j;
        }
        
        for(int i=1; i<dp.length; i++) {
            for (int j=1; j<dp[0].length; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) { // i-1 as we start the table with empty space.
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }
            }
        }
        return dp[m][n];
    }
}




