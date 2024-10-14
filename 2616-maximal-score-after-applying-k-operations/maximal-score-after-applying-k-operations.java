class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        long score=0;
        for(int x:nums){
            pq.offer(x);
        }
        while(!pq.isEmpty() && k-->0){
            int num=pq.poll();
            score+=num;
            if(num%3==0){
                num=num/3;
            }
            else{
                num=num/3+1;
            }
            if(num>0){
                pq.offer(num);
            }
        }
        return score;
    }
}