class Solution {
    /*
    Since we are concerned with making partitions such that we have the all the occurences
    in the partition, we would need to store the last occurence of each word in the string.
    Whenever we find a new letter in the string, we check if it's last occurence is further
    than previous letter, if yes, we update our partiton index else we go till last index
    and then reset our starting position so that we can find next partitions.
    T.C - O(N)
    */
    public List<Integer> partitionLabels(String S) {
        int[] lastIndex = new int[26];
        List<Integer> res = new ArrayList<>();
        for (int i=0; i< S.length(); i++) {
            lastIndex[S.charAt(i) - 'a'] = i; // finding last index of each letter in the string
        }
        int partitionIndex=0;
        int startIndex = 0;
        for (int i=0; i<S.length(); i++) {
            partitionIndex = Math.max(partitionIndex, lastIndex[S.charAt(i) - 'a']);
            
            if (i == partitionIndex) { // if we reach the partiton index, reset startIndex
                res.add(i - startIndex + 1);
                startIndex = i + 1;
            }
        }
        return res;
    }
}