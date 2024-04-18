// 小顶堆 -> 优先队列实现
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

// 快排
class Solution {
    private final static Random random = new Random(System.currentTimeMillis());
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k; // 第 k 个最大的元素

        int left = 0, right = nums.length - 1;
        while(true) {
            int pivot = partition(nums, left, right);
            if(pivot < target) left = pivot + 1;
            else if(pivot > target) right = pivot - 1;
            else return nums[pivot];
        }

    }
    public int partition(int[] nums, int left, int right) {
        // 不交换的话会超时
        int randomIndex = left + random.nextInt(right - left + 1);
        int temp = nums[randomIndex];
        nums[randomIndex] = nums[left];
        nums[left] = temp;


        int i = left, j = right;
        while(i < j) {
            while(i < j && nums[j] >= nums[left])
                j--;
            while(i < j && nums[i] <= nums[left])
                i++;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        int tmp = nums[i];
        nums[i] = nums[left];
        nums[left] = tmp;

        return i;
    }
}
