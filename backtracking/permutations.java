class Solution {
public List<List<Integer>> permute(int[] nums) {
   List<List<Integer>> list = new ArrayList<>();
   // Arrays.sort(nums); // not necessary
   backtrack(list, new ArrayList<>(), nums);
   return list;
}
    /*
    [1] -> [1,2] -> [1,2,3] -> [1,2] -> [1] -> [1,3] -> [1,3,2] -> [1,3] -> [1] -> [] -> 
    [2] -> [2,1] -> [2,1,3] -> [2,1] -> [2] -> [2,3] -> [2,3,1] -> [2,3] -> [2] -> [] ->
    [3] -> [3,1] -> [3,1,2] -> [3,1] -> [3] -> [3,2] -> [3,2,1] -> [3,2] -> [3] -> []
    */
    

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
   if(tempList.size() == nums.length){
      list.add(new ArrayList<>(tempList));
       return;
   } else{
      for(int i = 0; i < nums.length; i++){ 
         if(tempList.contains(nums[i])) continue; // element already exists, skip
         tempList.add(nums[i]); //
        System.out.println(Arrays.deepToString(tempList.toArray()));
         backtrack(list, tempList, nums);  
          System.out.println("here");
         tempList.remove(tempList.size() - 1); // [1,2]
        System.out.println(Arrays.deepToString(tempList.toArray()));
      }
   }
}
}