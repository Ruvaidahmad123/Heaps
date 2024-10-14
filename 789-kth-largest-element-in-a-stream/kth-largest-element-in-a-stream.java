class KthLargest {
    int heapsize;
    PriorityQueue<Integer>pq;
    public KthLargest(int k, int[] nums) {
        heapsize=k;
        pq=new PriorityQueue<>();
        for(int x:nums){
            pq.offer(x);
            if(pq.size()>k)pq.poll();
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size()>heapsize){
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */