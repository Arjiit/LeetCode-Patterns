class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) return false;
        
        Map<String, Set<String>> map = new HashMap<>();
        for (int i=0; i < pairs.size(); i++) {
            map.putIfAbsent(pairs.get(i).get(0), new HashSet<>());
            map.putIfAbsent(pairs.get(i).get(1), new HashSet<>());
            // putting both ways, as like we create a bi-directional graph
            map.get(pairs.get(i).get(0)).add(pairs.get(i).get(1));
            map.get(pairs.get(i).get(1)).add(pairs.get(i).get(0));
        }
        
        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) continue;
            if (!map.containsKey(words1[i])) return false;
            if (!map.get(words1[i]).contains(words2[i])) return false;
        }
        
        return true;
    }
}