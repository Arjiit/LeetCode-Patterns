class Solution {
    /*
    Number of bits in a number is Log(number)
    Inserting numbers in the trie. The maximum number in the array, would take more time
    as it has more bits, so Time to insert into Trie - O(log(max)) as log(max) is the
    number of bits in it.
    And to to insert N numbers it takes O(N) time.
    Quering too would O(log(max)) time as in worst case, we would be traversing through
    those number of bits in the Trie.
    */
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // initializing Trie
        Trie root = new Trie();
        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            Trie curNode = root;
            // inserting into Trie
            for (int j=31; j>=0; j--) {
                int curBit = (num >> j) & 1;
                if (curNode.children[curBit] == null) {
                    curNode.children[curBit] = new  Trie();
                }
                curNode = curNode.children[curBit];
            }
        }
        
        int max = Integer.MIN_VALUE;
        for (int num: nums) {
            Trie curNode = root;
            int sum = 0;
            // Since we want to maximize the xor. If two numbers have different bits at position 31,
            // then their xor will be greater than numbers that have similar bits at position 31 but different bits at position 0
            for (int i=31; i>=0; i--) {
                int curBit = (num >> i)&1; // this will give us the bit at the ith position
                if (curBit == 0) {
                    if (curNode.children[1] != null) {
                        sum = sum + (int)Math.pow(2,i);
                        curNode = curNode.children[1];
                    } else {
                        curNode = curNode.children[0];
                    }
                } else {
                    if (curNode.children[0] != null) {
                        sum = sum + (int)Math.pow(2,i);
                        curNode = curNode.children[0];
                    } else {
                        curNode = curNode.children[1];
                    }
                }
            }
            if (sum > max) {
               max = sum; 
            }
        }
        return max;
    }
}

class Trie {
    Trie[] children; // children would be of Trie type too
    public Trie() {
        children = new Trie[2];
        
    }
}

