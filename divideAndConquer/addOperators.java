/*
 we can choose + , - , * and empty space (in this case, eg. 12 was treated as one number), in total four kinds of choices. Also, remember there is a for loop inside every call stack, So, for the call stack of length N,
Total time complexity should be N * 4^(N - 1)
*/

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if(num == null || num.length() == 0) return res;
        dfs(res, sb, num, 0, target, 0, 0);
        return res;
    }
    
    public void dfs(List<String> res, StringBuilder sb, String num, int pos, int target, long prev, long multi) {
        if (num.length() == pos) {
            if (target == prev) {
                res.add(sb.toString());
            } 
            return;
        }
        
        for (int i=pos; i< num.length(); i++) {
            if (num.charAt(pos) == '0' && i != pos) {
                break;
            }
            
            long curr = Long.parseLong(num.substring(pos, i+1));
            int len = sb.length();
            
            if (pos == 0) {
                dfs(res, sb.append(curr), num, i+1, target, curr, curr);
                sb.setLength(len);
            } else {
                dfs(res, sb.append("+").append(curr), num, i+1, target, prev+curr, curr);
                sb.setLength(len);
                dfs(res, sb.append("-").append(curr), num, i+1, target, prev-curr, -curr); // multi is negative of curr
                sb.setLength(len);
                dfs(res, sb.append("*").append(curr), num, i+1, target, prev + curr*multi-multi, curr*multi); // multi is curr*mulit
                // we are saving the value that has to be multiplied in the next recursion as (curr + multi*curr - multi) will give us the correct value of prev
                sb.setLength(len);
            }
        }
    }
}