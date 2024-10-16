class Pair{
    char ch;
    int freq;
    Pair(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }
}
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p2.freq - p1.freq);
        if (a > 0) pq.offer(new Pair('a', a));
        if (b > 0) pq.offer(new Pair('b', b));
        if (c > 0) pq.offer(new Pair('c', c));
        StringBuilder sb = new StringBuilder();  
        while (!pq.isEmpty()) {
            Pair p1 = pq.poll();
            if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == p1.ch && sb.charAt(sb.length() - 2) == p1.ch) {
                if (pq.isEmpty()) {
                    break; 
                }
                Pair p2 = pq.poll();
                sb.append(p2.ch);
                p2.freq--;
                if (p2.freq > 0) {
                    pq.offer(p2);
                }
                pq.offer(p1); 
            } else {
                sb.append(p1.ch);
                p1.freq--;
                if (p1.freq > 0) {
                    pq.offer(p1);
                }
            }
        }
        return sb.toString();
    }
}
