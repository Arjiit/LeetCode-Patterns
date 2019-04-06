class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
        
        */
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, List<String>> hm = new HashMap<>();
        
        for (String s: strs) {
            char[] c = new char[26];
            
            for (int i=0; i< s.length(); i++) {
                c[s.charAt(i) - 'a']++;
            }
            
            String b = new String(c);
            
            if(hm.containsKey(b)) {
                hm.get(b).add(s);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(s);
                hm.put(b,temp);
            }
        }
        result.addAll(hm.values());
        
        return result;
    }
}