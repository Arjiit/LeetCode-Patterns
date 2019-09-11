class hit {
    int timeStamp;
    public hit(int timeStamp) {
        this.timeStamp = timeStamp;
    }
}
/*
Since timestamps are in order, we can use a queue to keep only
the ones within 5 minutes in the queue.
However, this may lead to huge space requirements, if there are
lot of hits at a particular timestamp, hence, at a larger scale,
we could use a hashmap with key as timestamp and value as
count of different hits.
*/

class HitCounter {

    /** Initialize your data structure here. */
    Queue<hit> hitRecorder;
    HashSet<Integer> hs;
    public HitCounter() {
        hitRecorder = new LinkedList<>();
        hs = new HashSet<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        hit h = new hit(timestamp);
        hitRecorder.add(h);
        
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (hitRecorder.size() > 0) {
            hit hitTime = hitRecorder.peek();
            int time = hitTime.timeStamp;
            if (timestamp >= time + 300) {
                hitRecorder.poll();
            } else {
                break;
            }
        }
        return hitRecorder.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */