class Pair {
    int val;
    int idx;

    Pair(int v, int i) {
        val = v;
        idx = i;
    }
}

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Pair> left = new PriorityQueue<>((a, b) -> {
            if (a.val != b.val) {
                return a.val - b.val;
            } else {
                return a.idx - b.idx;
            }
        });
        PriorityQueue<Pair> right = new PriorityQueue<>((a, b) -> {
            if (a.val != b.val) {
                return a.val - b.val;
            } else {
                return a.idx - b.idx;
            }
        });

        int i = 0;
        int j = costs.length - 1;
        long ans = 0;

        while (k-- > 0) {
            // Fill the left queue
            while (i <= j && left.size() < candidates) {
                left.offer(new Pair(costs[i], i));
                i++;
            }

            // Fill the right queue
            while (j >= i && right.size() < candidates) {
                right.offer(new Pair(costs[j], j));
                j--;
            }

            // Check if both queues have elements
            Pair a = left.size() > 0 ? left.peek() : null;
            Pair b = right.size() > 0 ? right.peek() : null;

            if (a == null) {
                ans += right.poll().val;
            } else if (b == null) {
                ans += left.poll().val;
            } else {
                // Choose the smaller value; if equal, choose the one with the smaller index
                if (a.val < b.val) {
                    ans += left.poll().val;
                } else if (a.val > b.val) {
                    ans += right.poll().val;
                } else {
                    // If values are the same, pick based on index
                    if (a.idx < b.idx) {
                        ans += left.poll().val;
                    } else {
                        ans += right.poll().val;
                    }
                }
            }
        }

        return ans;
    }
}
