class Logger {

    /** Initialize your data structure here. */
    HashMap<String, Integer> hm; 
    public Logger() {
        hm = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (hm.containsKey(message) && (timestamp < hm.get(message) + 10)) {
                return false;
            }
        hm.put(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */

 /*
 Using hashmap can be space intensive if we have large amount of logs,
 as we aren't deleting any and keeping the string as the key.
 Hence, better would be to keep PriorityQueue, that would on each new
 (message, timestamp) call element message from PriorityQueue that have
 expired by comparing with the timestamp.
 Infact, since timestamps are coming in order, we could have used Queue
 as well.
 */

     class Log {
        int timeStamp;
        String message;
        public Log(int timeStamp, String message) {
            this.timeStamp = timeStamp;
            this.message = message;
        }
    }
class Logger {    
    Set<String> set;

    /** Initialize your data structure here. */
    PriorityQueue<Log> onlyRecentLogs; // priorityqueue to remove old messages
    public Logger() {
        onlyRecentLogs = new PriorityQueue<Log>(10, new Comparator<Log>(){ // specifying capacity
            public int compare(Log l1, Log l2) {
                return l1.timeStamp - l2.timeStamp; // we want the messages with lower timestamp on top
            }
        });
        
        set = new HashSet<>(); // set to keep only recent logs
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        // now discard the logs which are expired from both
        
        while(onlyRecentLogs.size() > 0) {
            Log l = onlyRecentLogs.peek();
            if (timestamp - l.timeStamp >= 10){
                onlyRecentLogs.poll();
                System.out.println("here");
                set.remove(l.message);
            } else {
                break; // if the messages are within the timestamp, do nothing
            }
        }
        boolean res = !set.contains(message);
        if (res){
            set.add(message);
            onlyRecentLogs.add(new Log(timestamp, message));
        }
        return res;
    }
}
