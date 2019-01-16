class Solution {
    public int mySqrt(int x) {
        if(x < 1) return 0;
        int low = 1;
        int high = x;
        while(low <= high){
            int mid = (high - low) / 2 + low;
            if(x / mid == mid) return mid;
            if(x / mid > mid) low = mid + 1;
            if(x / mid < mid) high = mid - 1;
        }
        return high;
    }
}