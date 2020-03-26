class Solution {
    /*
    We will do a BFS to find neighbours for a word and add which level it is
    on wrt to start word. Once we have the map, we can do a dfs from start word
    to end word by looping over the neighbours for each word and ensuring they
    are one level away till we find the endword. Once endword is found we backtrack.
    */
    HashMap<String, Integer> distances;
    HashMap<String, List<String>> neighbours;
    List<List<String>> res;
    HashSet<String> words;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        distances = new HashMap<>();
        neighbours = new HashMap<>();
        res = new ArrayList<>();
        words = new HashSet<>(wordList);
        if (wordList == null || wordList.size() == 0 || !words.contains(endWord)) {
            return res;
        }
        bfs(beginWord, endWord, words);
        List<String> path = new ArrayList<>();
        path.add(beginWord); // adding beginword to the path
        dfs(beginWord, endWord, path);
        return res;
    }
    
    public void bfs(String beginWord, String endWord, HashSet<String> words) {
        if (beginWord.equals(endWord)) return;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int level = 0;
        distances.put(beginWord, level);
        while(!q.isEmpty()) {
            int s = q.size();
            for (int i=0; i<s; i++) {
                String curWord = q.poll();
                if (curWord.equals(endWord)) return;
                List<String> neighbors = getNeighbors(curWord, words);
                for(String n: neighbors) {
                    if (!distances.containsKey(n)) {
                        distances.put(n, level+1);
                        q.add(n);
                    }
                }
            }
            level++;
        }
    }
    public void dfs(String currWord, String endWord, List<String> path) {
        if (currWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        List<String> neighb = getNeighbors(currWord, words);
        for(String n: neighb) {
            if(distances.containsKey(n)) {
                // ensuring we are only moving forward and not going into cycle
                // adding the correct next word which is one level ahead
                if (distances.get(n) == distances.get(currWord) + 1) {
                    path.add(n);
                    dfs(n, endWord, path);
                    path.remove(path.size() - 1);  // backtracking
                }
            }
        } 
    }
            
    public List<String> getNeighbors(String word, HashSet<String> words) {
        char[] wordArr = word.toCharArray();
        List<String> neig = new ArrayList<>();
        for(int i=0; i<wordArr.length; i++) {
        for (char c ='a'; c<'z'; c++) {
            char temp = wordArr[i];
            wordArr[i] = c;
            String new_string = new String(wordArr);
            if (words.contains(new_string)) {
                neig.add(new_string);
            }
            wordArr[i] = temp;
        }
        }
        neighbours.put(word, neig);
        return neig;
    }
}