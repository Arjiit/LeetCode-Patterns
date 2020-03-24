class Solution {
    /*
    Quickselect - We select a pivot, and two pointers,(i and j)
    i starts from arr's start - 1 and j starts from arr's start.
    If arr[j] is smaller than element at pivot i.e. arr[end], we
    increment i and replace arr[i] and arr[j]. Once we have reached
    j till end - 1. We put arr[end] i.e. pivot in appropriate locatio.
    We do this recursively for the left half and the right half, to 
    make it sorted.
    */
    public int[][] kClosest(int[][] points, int K) {
        int i= 0;
        int j = points.length - 1;
        while(i < j) {
            int mid = partition(points, i, j); // we will get index where pivot will end up
            if (mid == K) {
                break;
            } else if (mid < K) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        int[][] res = new int[K][2];
        for (int k=0; k<K; k++) {
            res[k][0] = points[k][0];
            res[k][1] = points[k][1];
        }
        return res;
    }
    
    private int partition(int[][] points, int start, int end) {
        int[] pivot = points[end];
        int swapIndex = start - 1;
        for (int j = start; j<end; j++) {
            if (value(points[j]) < value(pivot)) {
                swapIndex++;
                swap(points, swapIndex, j); // swapping swapindex(i) and j
            }
        }
        //once all swaps have been done, put pivot to index swapindex(i) + 1
        swap(points, ++swapIndex, end);
        return swapIndex; // returning the final correct position of pivot
    }
    
    private int value(int[] a) {
        return a[0]*a[0] + a[1]*a[1];
    }
    
    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}