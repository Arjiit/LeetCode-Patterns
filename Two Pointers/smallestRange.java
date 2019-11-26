class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        /*
        O(n*m) - total lists*list length
        */
        int minx = 0;
        int miny = Integer.MAX_VALUE;
        int[] next = new int[nums.length]; // to store pointers for each k lists
        boolean flag = true; // flag to check if we reach end in any of the k lists
        
        for(int i=0; i<nums.length()&&flag; i++) {
            for (int j=0; j<nums.get(i).length()&&flag; j++) {
                int min_i = 0; // to store which list out of k has minimum
                int max_i = 0;
                for (int k=0; k< nums.length(); k++) { // traversing in all the k lists
                    if (nums.get(min_i).get(next[min_i]) > nums.get(k).get(next[k])) {
                        min_i = k; // noting down index of list that has minimum
                    }
                    if (nums.get(max_i).get(next[max_i]) < nums.get(k).get(next[k])) {
                        max_i = k;
                    }
                }
                if (min_y - min_x > nums.get(max_i).get(next[max_i]) - nums.get(min_i).get(next[min_i])) { // updating global min ranges for min and max
                    min_y = nums.get(max_i).get(next[max_i]);
                    min_x = nums.get(min_i).get(next[min_i]);
                }
                next[min_i]++; // inncrementing the pointer for the list that contained minimum
                if (next[min_i] == nums.get(min_i).length()){
                    flag = false; // if any of the list reaches end, we stop
                }
            }
        }
    }
}


class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        /*
        O(n*log(m) solution 
        */
        int min_x = 0;
        int min_y = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] next = new int[nums.size()]; // to store pointers for each k lists
        boolean flag = true; // flag to check if we reach end in any of the k lists
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((i,j) -> nums.get(i).get(next[i]) - nums.get(j).get(next[j]));
        
        for (int i=0; i<nums.size(); i++) {
            minHeap.offer(i); // will store index of the list out of k list that has smallest number
            max = Math.max(max, nums.get(i).get(0)); // will store the max number in all the k lists
        }
        
        for (int i=0; i<nums.size()&&flag; i++) {
            for (int j=0; j<nums.get(i).size()&&flag; j++) {
                int min_i = minHeap.poll();
                if (min_y - min_x > max - nums.get(min_i).get(next[min_i])) {
                    min_x = nums.get(min_i).get(next[min_i]);
                    min_y = max;
                }
                next[min_i]++;
                if (next[min_i] == nums.get(min_i).size()) {
                    flag = false;
                    break;
                }
                minHeap.offer(min_i);
                max = Math.max(max, nums.get(min_i).get(next[min_i]));
            }
        }
        return new int[] {min_x, min_y};
    }
}