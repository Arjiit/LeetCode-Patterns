class RLEIterator {
    int[] A;
    int index;
    /*
        Time - O(N)
        Space - O(1) since no extra space used.
    */

    public RLEIterator(int[] A) {
        this.A = A;
        index = 0;
    }
    
    public int next(int n) {
        while(index < A.length && n > A[index]) {
            n = n - A[index];
            index = index + 2;
        }
        
        if (index >= A.length) {
            return -1;
        }
        
        A[index] = A[index] - n;
        
        return A[index+1]; 
    }
}

/*
Using binary search - we do a binary search on the count
array so that our search space minimizes.
T.C. - O(logN)
*/

class RLEIterator {
    int[] arr;
    long[] count;
    long cur = 0;
    int low = 0;
    public RLEIterator(int[] A) {
        arr = new int[A.length/2];
        count = new long[A.length/2];
        for (int i=0; i<A.length; i+=2) {
            count[i/2] = A[i] + (i>1? count[i/2 - 1] : 0);
            arr[i/2] = A[i+1];
        }
    }
    
    public int next(int n) {
        if (count.length == 0) {
            return -1;
        }
        int l = low;
        int high = count.length - 1;
        cur = cur + n;
        
        if (cur > count[count.length - 1]) {
            return -1;
        }
        while(l < high) {
            int mid = l + (high - l)/2;
            if (count[mid] >=  cur){
                high = mid;
            } else {
                l = mid + 1;
            }
        }
        low = l; // since we want to start from new start next time round
        return arr[l];
    }
}
/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */