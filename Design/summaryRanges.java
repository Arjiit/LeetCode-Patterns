class SummaryRanges {
    TreeMap<Integer, int[]> lowerIntervals;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        lowerIntervals = new TreeMap<>();
    }
    // lowerKey(key) gets key strictly lower than the specified key.
    // O(logN) for adding as lowerKey(), higherKey(), put() and remove() are all O(logN).
    
    /*
    case 1) key lies between two existing interval and we need to merge the existing intervals.
    case 2) key is smaller than existing key and needs to be added in front.
    case 3) key is greater than existing key end value and needs to be added in last
    */
    
    public void addNum(int val) {
        if (lowerIntervals.containsKey(val)) return;
        Integer low = lowerIntervals.lowerKey(val);
        Integer high = lowerIntervals.higherKey(val); // will get key strictly higher
        if ((low != null) && (high != null) && (lowerIntervals.get(low)[1] + 1 == val) && (lowerIntervals.get(high)[0] - 1 == val)) {  
            lowerIntervals.get(low)[1] = lowerIntervals.get(high)[1];
            lowerIntervals.remove(high);
        } else if (low != null && lowerIntervals.get(low)[1] + 1 >= val) {
            lowerIntervals.get(low)[1] = Math.max(lowerIntervals.get(low)[1], val);
        } else if (high != null && lowerIntervals.get(high)[0] - 1 == val) {
            lowerIntervals.put(val, new int[]{val, lowerIntervals.get(high)[1]});
            lowerIntervals.remove(high);
        } else {
            lowerIntervals.put(val, new int[]{val, val});
        }
    }
    
    public int[][] getIntervals() {
        int[][] res = new int[lowerIntervals.size()][2];
        int i=0;
        for(int[] a: lowerIntervals.values()){
            res[i] = a;
            i++;
        }
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */