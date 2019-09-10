class Solution {
    /*
    T.C. - O(rows*word_length)
    */
    public int wordsTyping(String[] sentence, int rows, int cols) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<sentence.length;i++) {
            sb.append(sentence[i]);
            sb.append(" "); // End of the reformatted string is space as when the sentence has to be restarted, there should be space between characters
        }
        String reformattedString = sb.toString();
        
        int count = 0;
        int n = reformattedString.length();
        /*
        Here count is a variable used to identify the number of characters from the
        reformatted string to be displayed on the screen.
        Hence the value of count achieved after all rows are traversed divided by length of 
        reformatted string will give us the number of times it is preinted.
        Hence, we use % to loop around the reformatted string.
        If at the end of the 'count' i.e. 'count%n', we receive a ' ', we increment count,
        because that means we can put the word in the col area and need not worry about the space. If we encounter a non-space character, then we have to traverse backwards by reducing the value of count till we encounter space as a word cannot be partially be fitted on the screen.
        */
        for(int i=0; i<rows; i++) {
            count = count + cols; // at each row, we give total count needed to traverse
            if (reformattedString.charAt(count%n) == ' ') {
                count++;
            } else {
                while(count > 0 && reformattedString.charAt((count-1)%n) != ' ') {
                    count--;
                }
            }
        }
        return count/n;
    }
}