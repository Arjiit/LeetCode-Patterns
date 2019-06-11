class Solution {
    /*
    Idea is to count the number of characters that appear odd number of times.
    If they are more than one, then palindrome can't be formed.
    Next, we permute the string and add element before the odd element and
    add element after the middle element.
    */
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int[] ch = new int[256];
        
        for (int i=0; i< s.length();i++) {
            ch[s.charAt(i)]++;
        }
        int odd=0;
        for (int i=0; i< ch.length; i++) {
            if (ch[i]%2 != 0) {
                sb.append((char) i);
                odd++;
            }
        }
        
        if (odd > 1) {
            return res;
        }
        
        permute(sb, ch, res, s.length());
        return res;
    }
    
    public void permute(StringBuilder sb, int[] c, List<String> res, int len) {
        if (sb.length() == len) {
            res.add(sb.toString());
            return;
        }
        
        for(int i=0; i<c.length; i++) {
            if(c[i] > 1) { // so that we take care of cases when odd character is 1 times then
                // since we have already added, we don't want to consider that
                c[i] = c[i] - 2;
                sb.insert(0, (char) i); // appending at the start
                sb.append((char) i); // appending at the end
                
                permute(sb, c, res, len);
                // backtracking
                sb.deleteCharAt(0); // removing from the start
                sb.deleteCharAt(sb.length() - 1); // removing from the end
                c[i] = c[i] + 2;
                
            }
        }
    }
}


/*

Another way is to perform permutation on half of the list
and join it with other half and the middle element.

Here we will see how to avoid duplicates just like we saw in subsets 2.
*/



// generate all unique permutation from list
// list contains half characters minus the mid character.
void getPerm(List<Character> list, String mid, boolean[] used, StringBuilder sb, List<String> res) {
    if (sb.length() == list.size()) {
        // form the palindromic string
        res.add(sb.toString() + mid + sb.reverse().toString());
        sb.reverse();
        return;
    }

    for (int i = 0; i < list.size(); i++) {
        // avoid duplication
        if (i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) continue;
/*
                    skip the following 3 characters
               |  |     |
        [b, a, a, a, c, c, d]

        When we have tried the permutation begin with ba, we don't want to try another ba, so just skip the following 2 a, and build the permutation from bc.

        The same thing happens when we meet the 2nd c.
*/

        if (!used[i]) {
            used[i] = true; sb.append(list.get(i));
            // recursion
            getPerm(list, mid, used, sb, res);
            // backtracking
            used[i] = false; sb.deleteCharAt(sb.length() - 1);
        }
    }
}