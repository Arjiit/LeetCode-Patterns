class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> hm = new HashMap<>();
        
        for (int i=0; i<paths.length; i++) {
            String full_path = paths[i];
            String[] split = full_path.split(" ");
            String base_name = split[0];
            for (int j=1; j<split.length; j++) {
            String[] content = split[j].split("\\(");
            String file_name = content[0];
            String file_content = content[1];
            String path = base_name + "/" + file_name; 
            if (!hm.containsKey(file_content)) {
                List<String> res = new ArrayList<>();
                res.add(path);
                hm.put(file_content, res);
            } else {
                List<String> getList = hm.get(file_content);
                getList.add(path);
                hm.put(file_content, getList);
            }
            }
        }
        List<List<String>> final_list = new ArrayList<>();
        
        for (Map.Entry<String, List<String>> map: hm.entrySet()) {
            final_list.add(map.getValue());
        }
        return final_list;
    }
}