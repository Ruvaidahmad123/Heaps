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
