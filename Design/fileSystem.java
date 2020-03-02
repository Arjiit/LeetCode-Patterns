class FileSystem {
    HashMap<String, Integer> hm;
    public FileSystem() {
        hm = new HashMap<>();
        hm.put("", 0);
    }
    
    public boolean createPath(String path, int value) {
        int getLastIndex = path.lastIndexOf("/");
        String subPath = path.substring(0, getLastIndex);
        if (!hm.containsKey(subPath) || (hm.containsKey(path))) {
            return false;
        } 
        hm.put(path, value);
        return true;
    }
    
    public int get(String path) {
        if (hm.containsKey(path)) return hm.get(path);
        return -1;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */