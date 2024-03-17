class Solution {
    public int[] maxAltitude(int[] heights, int limit) {
        if(heights == null || heights.length == 0)
            return new int[0];
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[heights.length - limit + 1];

        for(int i = 0; i < heights.length; i++) {
            // poll掉比加入元素小的其他所有元素
            while(!queue.isEmpty() && heights[i] >= heights[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offer(i);
            // poll掉超出范围的元素
            if(queue.peekLast() - queue.peek() == limit) {
                queue.poll();
            }
            // 加入结果
            if(queue.peekLast() + 1 >= limit) {
                res[i + 1 - limit] = heights[queue.peek()];
            }
        }
        return res;
    }
}
