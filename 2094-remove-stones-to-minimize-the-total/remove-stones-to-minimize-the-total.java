class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int x:piles){
            pq.offer(x);
        }
        while(!pq.isEmpty() && k-->0){
            int x=pq.poll();
            int floor=x/2;
            x-=floor;
            pq.offer(x);
        }
        int sum=0;
        while(!pq.isEmpty()){
            sum+=pq.poll();
        }
        return sum;
    }
}