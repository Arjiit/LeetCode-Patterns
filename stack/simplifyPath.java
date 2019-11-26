public class Solution {
    
public String simplifyPath(String path) {
    
    Stack<String> stack = new Stack<String>();
    
    for (String s : path.split("/")){
        
        if (s.equals("..")){
            if(!stack.empty()){
                stack.pop();    
            }
        } else if (s.equals(".") || s.equals("")){
            continue;
        } else {
            stack.push(s);    
        }
    }
    if (stack.empty()){
        return "/";
    }
    String spath = "";
    while(!stack.empty()){
        spath = "/" + stack.pop() + spath;
    }
    return spath;
  }
}