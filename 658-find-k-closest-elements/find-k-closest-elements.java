class Pair{
    int diff;
    int val;
    Pair(int diff,int val){
        this.diff=diff;
        this.val=val;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{
            if(a.diff!=b.diff){
                return Integer.compare(b.diff,a.diff);
            }
            else{
                return Integer.compare(b.val,a.val);
            }
        });
        for(int i=0;i<arr.length;i++){
            pq.add(new Pair(Math.abs(arr[i]-x),arr[i]));
            if(pq.size()>k){
                pq.poll();
            }
        }
        List<Integer>ans=new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll().val);
        }
        Collections.sort(ans);
        return ans;
    }
}