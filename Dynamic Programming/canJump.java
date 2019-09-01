class Solution {
    public boolean canJump(int[] nums) {
    // TLE exceeded solution
        
        return canJumpFromPosition(0, nums);
    }
    
    public boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }
        return false;
    }
    
}

/*
    Using memoization, to store the result of particular position in an 
    array. T.C. - O(n^2)
*/

enum Index {
    GOOD,BAD, UNKNOWN; // for marking a position as one of these
}
class Solution {
    Index[] memo;
    
    public boolean canJump(int[] nums) {
        memo = new Index[nums.length];
        for (int i=0; i< memo.length; i++) {
            memo[i] = Index.UNKNOWN; // initially all elements are UNKNOWN
        }
        memo[memo.length - 1] = Index.GOOD; // except last one as it can reach itself
        return canJumpFromPosition(0, nums);
    }
    
    public boolean canJumpFromPosition(int position, int[] nums) {
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD ? true: false; // if it is known, return that
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }
        // if the execution reaches here, we can mark the position as bad
        memo[position] = Index.BAD;
        return false;
    }
    
}