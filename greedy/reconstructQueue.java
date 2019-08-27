class Solution {
    public int[][] reconstructQueue(int[][] people) {
        /*
            To sort t.c. O(nlogn) and to insert n elements, each of which takes
            O(k) time. Hence T.C - O(N^2)
        */
        // if height is same, then compare by k-values. smaller k-values shall come first
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> list = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1], people[i]); // adding at the index position
        }
        int[][] res = new int[people.length][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}