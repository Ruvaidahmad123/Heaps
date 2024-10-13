class Pair{
    int x;
    int y;
    double dist;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
        this.dist=Math.sqrt(x*x+y*y);
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{
            if(a.dist!=b.dist){
                return Double.compare(b.dist, a.dist);
            }
            else
            return 0;
        });
        for(int i=0;i<points.length;i++){
            pq.add(new Pair(points[i][0],points[i][1]));
            if(pq.size()>k){
                pq.poll();
            }
        }
        int ans[][]=new int[pq.size()][2];
        int idx=0;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            ans[idx][0]=p.x;
            ans[idx][1]=p.y;
            idx++;
        }
        return ans;
    }
}