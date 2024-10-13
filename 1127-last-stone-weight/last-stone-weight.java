class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int x:stones){
            pq.offer(x);
        }
        while(pq.size()>1){
            int max1=0,max2=0;
            if(!pq.isEmpty()){
                max1=pq.poll();
            }
            if(!pq.isEmpty()){
                max2=pq.poll();
            }
            int after=max1-max2;
            if(after>0)pq.offer(after);
        }
        if(!pq.isEmpty())
        return pq.peek();
        else 
        return 0;
    }
}