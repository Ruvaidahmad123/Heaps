class Solution { // 18 ms, faster than 32.44%
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length, ans = -1; // For general, the matrix need not be a square
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int r = 0; r < Math.min(m, k); ++r)
            minHeap.offer(new int[]{matrix[r][0], r, 0});

        for (int i = 1; i <= k; ++i) {
            int[] top = minHeap.poll();
            int r = top[1], c = top[2];
            ans = top[0];
            if (c + 1 < n) minHeap.offer(new int[]{matrix[r][c + 1], r, c + 1});
        }
        return ans;
    }
}


//binary search
class Solution {
    public int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left; // Returns the index of the first element greater than target
    }

    public int isCount(int[][] matrix, int mid) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            count += upperBound(matrix[i], mid); // Count elements <= mid in each row
        }
        return count;
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isCount(matrix, mid) < k) {
                low = mid + 1; // Move to the right part of the search space
            } else {
                high = mid; // Move to the left part of the search space
            }
        }
        return low; // Low will be the kth smallest element
    }
}
