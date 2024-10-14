class Solution {
    public int countLessEqual(int m, int n, int target) {
        int count = 0;
        // Iterate through each row and count how many elements <= target
        for (int i = 1; i <= m; i++) {
            count += Math.min(n, target / i);
        }
        return count;
    }

    public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m * n;

        while (low < high) {
            int mid = low + (high - low) / 2;
            // If the number of elements <= mid is less than k, search on the right half
            if (countLessEqual(m, n, mid) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low; // 'low' will be the kth smallest element
    }
}
