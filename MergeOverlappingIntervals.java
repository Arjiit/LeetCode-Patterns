//Trapping water
Class Interval {
    int id;
    int s;
    int e;
    int t;
    public Interval(int time, int id, int start, int end) {
        this.id = id;
        this.t = time;
        this.s = start;
        this.e = end;
    }
}


public class MergeOverlappingIntervals { 
  
    // The main function that takes a set of intervals, merges  
    // overlapping intervals and prints the result  
    public static void mergeIntervals(List<List<Integer>> vehicleAssignments, int id)  
    {  
        // Test if the given set has at least one interval  
        if (arr.length <= 0)  
            return;  
        Interval[] arr = new Interval[vehicleAssignments.size()];
        for (int i=0; i<vehicleAssignments.size(); i++) {
            Interval it = new Interval(vehicleAssignments.get(i).get(0), vehicleAssignments.get(i).get(1), vehicleAssignments.get(i).get(2),vehicleAssignments.get(i).get(3));
            arr[i] = it;
        }
    
        // Create an empty stack of intervals  
        Stack<Interval> stack=new Stack<>(); 
    
        // sort the intervals in increasing order of start time  
        Arrays.sort(arr,new Comparator<Interval>(){ 
            public int compare(Interval i1,Interval i2) 
            { 
                return i1.s-i2.s; 
            } 
        }); 
    
        // push the first interval to stack  
        stack.push(arr[0]);  
    
        // Start from the next interval and merge if necessary  
        for (int i = 1 ; i < arr.length; i++)  
        {  
            // get interval from stack top  
            Interval top = stack.peek();  
    
            // if current interval is not overlapping with stack top,  
            // push it to the stack  
            if (top.e < arr[i].s)  
                stack.push(arr[i]);  
    
            // Otherwise update the ending time of top if ending of current  
            // interval is more  
            else if (top.e < arr[i].e)  
            {  
                top.e = arr[i].e;  
                stack.pop();  
                stack.push(top);  
            }  
        }  
    
        // Print contents of stack  
        System.out.print("The Merged Intervals are: "); 
        while (!stack.isEmpty())  
        {  
            Interval t = stack.pop(); 
            if (t.id == id) {
            System.out.print("["+t.s+","+t.e+"] "); 
        }
        }   
    }   
  
    public static void main(String args[]) { 
        List<List<Integer>> list = asList(
                             asList(100,3005,660000, 660200),
                             asList(100,3006,660000, 660200),
                             asList(100,3007,700000, 700200),
                             asList(200,3008,660000, 660500)
                           );
 
        mergeIntervals(list, 100); 
    } 
} 
  