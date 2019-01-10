class Solution {
    public int hIndex(int[] citations) {
        
        int l = 0;
        int r = citations.length - 1;
        int n = citations.length;
        while(l <= r) {
            int mid = l + (r-l)/2;
            
            if (citations[mid] == n - mid) {
                return n-mid;
            } else if (citations[mid] > n- mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return n - l;
    }
}