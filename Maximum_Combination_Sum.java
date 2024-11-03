public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        // Sort both arrays in descending order
        Collections.sort(A, Collections.reverseOrder());
        Collections.sort(B, Collections.reverseOrder());

        // Max heap to store the maximum sums and their corresponding indices
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        // Set to track visited pairs
        Set<String> visited = new HashSet<>();

        // Initialize the heap with the maximum possible sum from A[0] + B[0]
        maxHeap.offer(new int[]{A.get(0) + B.get(0), 0, 0});
        visited.add("0,0");

        // Result list to store the top C sums
        ArrayList<Integer> result = new ArrayList<>();

        // Extract the top C sums
        for (int count = 0; count < C && !maxHeap.isEmpty(); count++) {
            int[] current = maxHeap.poll();
            int sum = current[0];
            int i = current[1];
            int j = current[2];

            // Add the maximum sum to the result
            result.add(sum);

            // Consider the next element in A with the current element in B
            if (i + 1 < A.size() && !visited.contains((i + 1) + "," + j)) {
                maxHeap.offer(new int[]{A.get(i + 1) + B.get(j), i + 1, j});
                visited.add((i + 1) + "," + j);
            }

            // Consider the next element in B with the current element in A
            if (j + 1 < B.size() && !visited.contains(i + "," + (j + 1))) {
                maxHeap.offer(new int[]{A.get(i) + B.get(j + 1), i, j + 1});
                visited.add(i + "," + (j + 1));
            }
        }

        return result;
    }
}
