class Solution {
    /*
    we use boolean array to record the sorted status of the string.
    sorted[i] = true if and only if A[i] < A[i + 1]
    so, if i reaches lengthOfArray, we are sure that it is sorted (or atleast <=)
    so we mark it as true and in next column iteration (j), it doesn't check
    for those i's.
    O(M*N) solution
    ["ca","bb","ac"]
    We check "ca" first and update it's result in sorted[] array and also maintain
    a count to check how many deletions we require which can be found by iterating
    within "ca".

    */
        public int minDeletionSize(String[] A) {
        int res = 0, n = A.length, m = A[0].length(), i, j;
        boolean[] sorted = new boolean[n - 1];
        for (j = 0; j < m; ++j) {
            System.out.println("j value is " + j);
            for (i = 0; i < n - 1; ++i) {
                if (!sorted[i] && A[i].charAt(j) > A[i + 1].charAt(j)) {
                    res++;
                    System.out.println("value of res " + res);
                    break;
                }
            }
            System.out.println("i value is " + i);
            if (i < n - 1) continue;
            // when i reaches n-1 that means, we have all the elements in that i, sorted,
            // so we update the sorted array.
            for (i = 0; i < n - 1; ++i)
                if (A[i].charAt(j) < A[i + 1].charAt(j))
                    sorted[i] = true;
        }
        return res;
    }
}