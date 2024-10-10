class Solution {
    static int[] replaceWithRank(int arr[], int N) {
     int ans[]=new int[N];
     PriorityQueue<Integer>pq=new PriorityQueue<>();
     for(int x:arr){
         pq.add(x);
     }
     int count=0;
     HashMap<Integer,Integer>map=new HashMap<>();
     while(!pq.isEmpty()){
         int x=pq.poll();
         if(!map.containsKey(x))
         map.put(x,++count);
     }
     for(int i=0;i<N;i++){
         ans[i]=map.get(arr[i]);
     }
     return ans;
  }
}
