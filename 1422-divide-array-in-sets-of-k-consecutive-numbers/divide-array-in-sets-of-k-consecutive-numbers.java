class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length%k!=0)return false;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        PriorityQueue<Integer>pq=new PriorityQueue<>(map.keySet());
        while(!pq.isEmpty()){
            int start=pq.poll();
            if (map.getOrDefault(start, 0) == 0) continue;
            int freq=map.get(start);
            for(int i=0;i<k;i++){
                int current=start+i;
                if(map.getOrDefault(current,0)<freq)return false;
                map.put(current, map.get(current) - freq);
                if(map.get(current)==0)map.remove(current);
            }
        }
        return true;
    }
}