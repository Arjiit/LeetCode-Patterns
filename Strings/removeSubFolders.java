class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();
        Arrays.sort(folder);
        String prev = folder[0] + "/";
        res.add(folder[0]);
        for (int i=1; i <folder.length; i++) {
            if (!folder[i].startsWith(prev)) {
                res.add(folder[i]);
                prev = folder[i] + "/";
            }
        }
        return res;
    }
}