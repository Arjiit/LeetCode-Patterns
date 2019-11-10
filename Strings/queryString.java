class Solution {
    public boolean queryString(String S, int N) {
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