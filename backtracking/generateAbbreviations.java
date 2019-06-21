class Solution {
    /*
    This is definitely O(2^n). It is easy to explain. Every char has two possibilities, either         abbreviate it or omit it. So there are total 2^n possibilities.
    Use StringBuilder to reduce time as doing + operations on String makes a new string, since
    string is immutable.
    If stringbuilder is used, then use setLength to backtrack.

    */
    public List<String> generateAbbreviations(String word) {
       List<String> res = new ArrayList<>();
        backtrack(res, word, 0, "", 0);
        return res;
    }
    /*
    pos pointer to current character
    cur pointer for the current string formed
    count - letters that are abbreviated in current streak
    */
    /*
    4 -> 3d -> 2r1 -> 
    */
    public void backtrack(List<String> res, String word, int pos, String cur, int count) {
        if (pos == word.length()) {
            if (count > 0) {
                cur = cur + count;
            }
            System.out.println(cur);
            res.add(cur);
            return;
        }else {
            System.out.println("abbreviate the letter");
            backtrack(res, word, pos+1, cur, count + 1); // we abbreviate the letter
            // we keep the letter as it is
            System.out.println("keep it");
            System.out.println(cur);
            cur = cur + ((count > 0) ? count:"") + word.charAt(pos); // "" + 3 + "d"
            backtrack(res, word, pos+1, cur, 0);
        }
}
}