class Pair{
    int processing_time;
    int idx;
    Pair(int p,int i){
        processing_time=p;
        idx=i;
    }
}
class Solution {
    public int[] getOrder(int[][] tasks) {
        ArrayList<int[]> sorted_t = new ArrayList<>();
        for (int i = 0; i < tasks.length; i++) {
            sorted_t.add(new int[]{tasks[i][0], tasks[i][1], i}); 
        }
        sorted_t.sort((a1, a2) -> Integer.compare(a1[0], a2[0])); 
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{
            if(a.processing_time!=b.processing_time){
                return a.processing_time-b.processing_time;
            }
            else{
                return a.idx-b.idx;
            }
        });
        long curr_time=0;
        int idx=0;
        int n=sorted_t.size();
        int []res=new int[n];
        int ansidx=0;
        while(idx<n || !pq.isEmpty()){
            if(pq.isEmpty() && curr_time<sorted_t.get(idx)[0]){
                curr_time=sorted_t.get(idx)[0];
            }
            while(idx<n && sorted_t.get(idx)[0]<=curr_time){
                pq.offer(new Pair(sorted_t.get(idx)[1],sorted_t.get(idx)[2]));
                idx++;
            }
            Pair p=pq.poll();
            curr_time+=p.processing_time;
            res[ansidx++]=(p.idx);
        }
        return res;
    }
}