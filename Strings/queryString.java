class Solution {
    public boolean queryString(String S, int N) {
        /*
        The solution can be improve a half by checking from N to N/2.
The reason is simply for every i < N/2, the binary string of 2*i will contain binary string of i. Thus we don't need to check for i < N/2
        */
        int n = 1;
        List<String> res = new ArrayList<>();
        while (n <= N) {
            String binaryString = Integer.toBinaryString(n);
            res.add(binaryString);
            if (!S.contains(binaryString)) {
                return false;
            }
            n++;
        }
        return true;
    }
}