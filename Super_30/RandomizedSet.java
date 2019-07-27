class RandomizedSet {

    /*
    nums.remove(val) is an O(n) operation. Hence, we have to somehow swap the removing element to the
    end of the list and remove it which will be an O(1) operation.
    */
    /** Initialize your data structure here. */
    HashMap<Integer, Integer> hs;
    ArrayList<Integer> nums;
    java.util.Random rand = new java.util.Random();
    public RandomizedSet() {
        hs = new HashMap<Integer, Integer>();
        nums = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!hs.containsKey(val)) {
            hs.put(val, nums.size());
            nums.add(val);
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (hs.containsKey(val)) {
            int location = hs.get(val);
            // we will check if it's not the last position then swap the value to be removed and put it at last location
            if (location < nums.size() - 1) {
                int lastOne = nums.get(nums.size() - 1);
                nums.set(location, lastOne); // putting element at last location at where val is being removed from
                hs.put(lastOne, location); // putting element at location from where val is removed in hashmap
            }
            nums.remove(nums.size() - 1); //removing from end of list - O(1) operation 
            hs.remove(val);
            return true;
        }
        return false;       
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get( rand.nextInt(nums.size()) );
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */