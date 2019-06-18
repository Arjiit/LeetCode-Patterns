class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        boolean inorder = true;
        getList(n, res, new ArrayList<>(), inorder);
        return res;
    }
    /*
    [] -> [0] -> [0,0] -> [0,0,0] -> [0,0,1] -> [0,0] -> [0] 
    -> [0,1] -> [0,1,1] -> [0,1] -> [0,1,0] -> [0,1] -> [0] -> []
    -> [1] -> [1,1] -> [1,1,1] -> [1,1] -> [1,0] -> [1,0,1]...
    */
    
    public void getList(int n, List<Integer> res, List<Character> temp, boolean inorder) {
        if (temp.size() == n) {
            res.add(binaryToInt(temp));
            return;
        }
        
            if (temp.size() == 0 || inorder) {
                temp.add('0');
                        System.out.println(Arrays.deepToString(temp.toArray()));
                getList(n, res, temp, true);
                System.out.println("this");
                temp.remove(temp.size() - 1);
                        System.out.println(Arrays.deepToString(temp.toArray()));
                temp.add('1');
                        System.out.println(Arrays.deepToString(temp.toArray()));
                getList(n, res, temp, false);
                temp.remove(temp.size() - 1);
                        System.out.println(Arrays.deepToString(temp.toArray()));
            } else {
                temp.add('1');
                System.out.println(inorder);
                        System.out.println(Arrays.deepToString(temp.toArray()));
                getList(n, res, temp, true);
                temp.remove(temp.size() - 1);
                temp.add('0');
                        System.out.println(Arrays.deepToString(temp.toArray()));
                getList(n, res, temp, false);
                temp.remove(temp.size()-1);
                        System.out.println(Arrays.deepToString(temp.toArray()));
            }
    }
    
        private int binaryToInt(List<Character> str) {
        if (str.size() == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < str.size(); i++) {
            if (str.get(str.size() - 1 - i)=='1') {
                sum |= 1 << i;
            }
        }
        return sum;
    }
    
    
    
    public int binaryToDecimal(int n) 
    { 
        int num = n; 
        int dec_value = 0; 
  
        // Initializing base 
        // value to 1, i.e 2^0 
        int base = 1; 
  
        int temp = num; 
        while (temp > 0) { 
            int last_digit = temp % 10; 
            temp = temp / 10; 
  
            dec_value += last_digit * base; 
  
            base = base * 2; 
        } 
  
        return dec_value; 
    }
}