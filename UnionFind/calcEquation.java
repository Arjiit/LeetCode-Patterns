class Solution {
    /*
    Using union find, we want to first connect all nodes through the equation relation.
    Compress all relations to a common variable. (find and union method)
    Building process O(nlogn), after that, every time, we query a equation, takes O(logn) .  For this issue: O(n*logn + q*logn)

    */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UF uf = new UF();
        for (int i=0; i<values.length; i++) {
            uf.Union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }
        
        double res[] = new double[queries.size()];
        for (int i=0; i< queries.size(); i++) {
            res[i] = uf.get(queries.get(i).get(0), queries.get(i).get(1));
        }
        return res;
    }
}

class UF {
    HashMap<String, String> p; // to store relation between two variables
    
    HashMap<String, Double> r; //to store value of relation, two-way
    
    UF() { // initializing the union find
        p = new HashMap<>();
        r = new HashMap<>();
    }
    
    String find(String a) { // find and compress the path to parent
        if (!p.containsKey(a)) {
            p.put(a,a);
            r.put(a, 1.0);
            return a; // parent of variable is itself in the beginning
        }
        
        double value = r.get(a);
        String parent = a; // initializing parent to itslef before looping to find actual parent
        
        while(p.get(parent) != parent) { // essentially p.get(a) != a
            parent = p.get(parent);
            value = value*r.get(parent); // multiplying the values along the way
        }
        // once we have found the parent, we update a with its new parent and it's new value
        p.put(a, parent);
        r.put(a, value);
        
        return parent;
    }
    
    void Union(String a, String b, double v) {
        String p1 = find(a);
        String p2 = find(b);
        
        if (p1 == p2) return; //if parents are the same then return
        
        double r1 = r.get(a);
        double r2 = r.get(b);
        
        p.put(p2, p1);
        r.put(p2, r1/r2*v);
    }
    
    double get(String a, String b) { //custom method to get actual division result
        if (!p.containsKey(a) || !p.containsKey(b)) {
            return -1.0;
        }
        
        String p1 = find(a);
        String p2 = find(b);
        
        if (p1 != p2) { // parents are different or they are not connected
            return -1.0;
        }
        /*
        
        */
        
        return r.get(b)/r.get(a);
    }
}