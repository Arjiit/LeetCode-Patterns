class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
       // store string with index in hashmap, iterate over the second list and check
       /*
       T.C. - O(l1 + l2)
       Space - O(l1*avg length of string in l1)
       */
        HashMap<String, Integer> hm = new HashMap<>();
        List<String> res = new ArrayList<>(); // to store result
        for (int i=0; i< list1.length; i++) {
            hm.put(list1[i], i);
        }
        int min_sum = Integer.MAX_VALUE;
        int sum = Integer.MAX_VALUE;
        for (int i=0; i<list2.length; i++) {
            if (hm.containsKey(list2[i])) {
                sum = i + hm.get(list2[i]);
                if (sum < min_sum) {
                    res.clear(); // to clear the list of previous values
                    res.add(list2[i]);
                    min_sum = sum;
                } else if (sum == min_sum) {
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }
}