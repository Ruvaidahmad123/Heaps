class Pair{
    String word;
    int freq;
    Pair(String word,int freq){
        this.word=word;
        this.freq=freq;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Pair>pq=new PriorityQueue<>((p1,p2)->{
            if(p1.freq!=p2.freq){
                return p1.freq-p2.freq;
            }
            else{
                return p2.word.compareTo(p1.word);
            }
        });
        HashMap<String,Integer>map=new HashMap<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        for(Map.Entry<String, Integer> e:map.entrySet()){
            pq.offer(new Pair(e.getKey(),e.getValue()));
            if(pq.size()>k){
                pq.poll();
            }
        }
        List<String>ans=new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll().word);
        }
        Collections.reverse(ans);
        return ans;
    }
}