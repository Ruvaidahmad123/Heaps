class MedianFinder {
    PriorityQueue<Integer> left_maxheap;
    PriorityQueue<Integer> right_minheap;

    public MedianFinder() {
        left_maxheap = new PriorityQueue<>(Collections.reverseOrder());
        right_minheap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (left_maxheap.isEmpty()) {
            left_maxheap.offer(num);
            return;
        }
        if (num > left_maxheap.peek()) {
            right_minheap.offer(num);
        } else {
            left_maxheap.offer(num);
        }
        // Balance the heaps
        if (right_minheap.size() > left_maxheap.size()) {
            left_maxheap.offer(right_minheap.poll());
        } else if (left_maxheap.size() > right_minheap.size() + 1) {
            right_minheap.offer(left_maxheap.poll());
        }
    }

    public double findMedian() {
        if (left_maxheap.size() > right_minheap.size()) {
            return left_maxheap.peek();
        } else {
            return (left_maxheap.peek() + right_minheap.peek()) / 2.0;
        }
    }
}
