class Solution {
    public int[] constructArray(int n, int k) {
        /*
        idea is to keep reversing the elements on top of each other from
        index 0 to index k-1.
        k=1, [1,6,5,4,3,2], k=2, [1,6,2,3,4,5], k=3, [1,6,2,5,3,4]
        */
        int res[] = new int[n];
        int left = 1;
        int right = n;
        for (int i=0; i<n; i++) {
            if (k%2 == 0) {
                res[i] = left++;
            } else {
                res[i] = right--;
            }
            
            if (k > 1) {
                k--;
            }
        }
        return res;
    }
}