class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();

        // 加入k个元素
        for(int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        // 从k+1个开始判断与堆顶元素的大小
        for(int i = k; i < nums.length; i++) {
            if(nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
