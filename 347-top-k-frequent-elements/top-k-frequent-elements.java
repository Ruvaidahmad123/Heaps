class Pair{
    int freq;
    int val;
    Pair(int freq,int val){
        this.freq=freq;
        this.val=val;
    }
}
class Solution {
    public int[] topKFrequent(int[] arr, int k) {
        if(arr.length==1){
            return arr;
        }
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Priority queue to store pairs
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.freq != b.freq) {
                return a.freq - b.freq; // Ascending order of frequency
            } else {
                return a.val - b.val; // Ascending order of value
            }
        });

        // Add pairs to the priority queue
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            pq.add(new Pair(entry.getValue(), entry.getKey()));
            if (pq.size() > k) {
                pq.poll(); // Remove the least frequent element
            }
        }
        int ans[]=new int[k];
        int idx=0;
        while(!pq.isEmpty() && idx<k){
            ans[idx++]=pq.poll().val;
        }
        return ans;
    }
}