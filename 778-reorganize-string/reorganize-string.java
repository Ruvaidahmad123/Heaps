class Pair{
    char c;
    int freq;
    Pair(char c,int freq){
        this.c=c;
        this.freq=freq;
    }
}
class Solution {
    public String reorganizeString(String s) {
        int arr[]=new int[26];
        for(char c:s.toCharArray()){
            arr[c-'a']++;
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{
            return b.freq-a.freq;
        });
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                pq.offer(new Pair((char)(i+'a'),arr[i]));
            }
        }
        StringBuilder sb=new StringBuilder();
        char prev='c';
        while(!pq.isEmpty()){
            List<Pair> temp = new ArrayList<>();
            int count=0;
            int limit=2;
            while(limit-- >0 && !pq.isEmpty()) {
                Pair p = pq.poll();
                if(sb.toString().equals("")){
                    // System.out.println("Hello");
                    sb.append(p.c);
                    prev=p.c;
                }
                else{
                    if(p.c==prev){
                        return "";
                    }
                    else{
                        sb.append(p.c);
                        prev=p.c;
                    }
                }
                if (p.freq - 1 > 0) {
                    temp.add(new Pair(p.c,p.freq-1));
                }
                count++;
            }
            pq.addAll(temp);
        }
        return sb.toString();
    }
}