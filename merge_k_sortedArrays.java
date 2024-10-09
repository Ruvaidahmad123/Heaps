class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int i=0;i<K;i++){
            for(int j=0;j<K;j++){
                pq.add(arr[i][j]);
            }
        }
        ArrayList<Integer>ans=new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        return ans;
    }
}
