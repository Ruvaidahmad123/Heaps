//Complete Brute Force using MinHeap - TIME COMPLEXITY = O(m*n*log(k)) - TLE
import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // Min-heap to store pairs based on their sum
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int m = nums1.length;
        int n = nums2.length;

        // Generate all possible pairs and add their sums to the priority queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums1[i] + nums2[j];

                if (pq.size() < k) {
                    pq.offer(new int[]{sum, i, j}); // Store sum and indices
                } else if (pq.peek()[0] > sum) {
                    pq.poll(); // Remove the largest sum in the heap
                    pq.offer(new int[]{sum, i, j});
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        // Collect the k smallest pairs from the heap
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int i = temp[1];
            int j = temp[2];
            result.add(Arrays.asList(nums1[i], nums2[j]));
        }

        return result;
    }
}

//Approach-2 (Improved BRUTE FORCE) 
//Complete Brute Force using MinHeap - TIME COMPLEXITY < O(m*n*log(k)) - ACCEPTED
import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // Min-heap to store pairs based on their sum
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int m = nums1.length;
        int n = nums2.length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums1[i] + nums2[j];

                if (pq.size() < k) {
                    pq.offer(new int[]{sum, i, j}); // Store sum and indices
                } else if (pq.peek()[0] > sum) {
                    pq.poll(); // Remove the largest sum in the heap
                    pq.offer(new int[]{sum, i, j});
                } else {
                    break; // Slight improvement: Break if the current sum is greater than the largest sum in the heap
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int i = temp[1];
            int j = temp[2];
            result.add(Arrays.asList(nums1[i], nums2[j]));
        }

        return result;
    }
}

//Approach-3 (Slight Better approach) - O(klog(k))
import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
            Integer.compare(a[0] + a[1], b[0] + b[1])); 
        Set<String> visited = new HashSet<>();
        visited.add("0,0");
        if (m > 0 && n > 0) {
            pq.offer(new int[]{nums1[0], nums2[0], 0, 0}); // {num1, num2, index1, index2}
        }
        List<List<Integer>> result = new ArrayList<>();

        while (k-- > 0 && !pq.isEmpty()) {
            int[] temp = pq.poll();
            result.add(Arrays.asList(temp[0], temp[1]));

            int i = temp[2];
            int j = temp[3];

            // Push (i, j+1) if possible
            if (j + 1 < n && !visited.contains(i + "," + (j + 1))) {
                pq.offer(new int[]{nums1[i], nums2[j + 1], i, j + 1});
                visited.add(i + "," + (j + 1));
            }

            // Push (i+1, j) if possible
            if (i + 1 < m && !visited.contains((i + 1) + "," + j)) {
                pq.offer(new int[]{nums1[i + 1], nums2[j], i + 1, j});
                visited.add((i + 1) + "," + j);
            }
        }

        return result;
    }
}
