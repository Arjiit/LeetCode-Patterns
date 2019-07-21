class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int word1 = 0;
        int word2 = 0;
        for (int i=0; i< words.length-1; i++) {
            while(word1 < words[i].length() && word2 < words[i+1].length()) {
                System.out.println(words[i].charAt(word1));
                System.out.println(words[i+1].charAt(word2));
                // check index value in the dictionary
                if (order.indexOf(words[i].charAt(word1)) < order.indexOf(words[i+1].charAt(word2))) {
                    break;
                }
                else if (order.indexOf(words[i].charAt(word1)) > order.indexOf(words[i+1].charAt(word2))){
                    return false;
                } else {
                    word1++;
                    word2++;
                }
            }
            if (i+1 == words.length - 1) { // to take care of corner case when both the words have same alphabets but one is shorter
                
                if ((word1 == words[i].length()) || (word2 == words[i+1].length())) {
                    return (words[i].length() > words[i+1].length()) ? false: true;
                }
            }
        }
        return true;
    }
}


/*
Or we can maintain an array to keep track of the position of alphabets of order string.
int[] mapping = new int[26];
        for (int i = 0; i < order.length(); i++)
            mapping[order.charAt(i) - 'a'] = i;

*/