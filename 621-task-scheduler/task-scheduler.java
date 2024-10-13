class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for (char ch : tasks) {
            arr[ch - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int freq : arr) {
            if (freq > 0) {
                pq.offer(freq);
            }
        }

        int time = 0;
        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int count=0;
            int limit=n+1;
            while(limit-- >0 && !pq.isEmpty()) {
                int freq = pq.poll();
                if (freq - 1 > 0) {
                    temp.add(freq - 1);
                }
                count++;
            }
            pq.addAll(temp);
            if (pq.isEmpty()) {
                time += count;
            } else {
                time += n + 1;
            }
        }
        return time;
    }
}
