// 法一：小顶堆 -> 优先队列实现
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

// 法二：手写一个堆
class Solution {
    public int findKthLargest(int[] nums, int k) {
        buildMinHeap(nums, k);
        for(int i = k; i < nums.length; i++) {
            if(nums[i] > nums[0]) {
                nums[0] = nums[i];
                minHeapify(nums, k, 0);
            }
        }
        return nums[0];
    }

    int left(int i) {
        return 2 * i + 1;
    }
    int right(int i) {
        return 2 * i + 2;
    }
    int parent(int i) {
        return (i - 1) / 2;
    }
    void buildMinHeap(int[] nums, int heapSize) {
        // 最后一个元素的索引是 k - 1，即headSize - 1
        for(int i = parent(heapSize - 1); i >= 0; i--) {
            minHeapify(nums, heapSize, i);
        }
    }
    void minHeapify(int[] nums, int heapSize, int i) {
        while (true) {
        // 判断节点 i, l, r 中值最小的节点，记为 min
        int l = left(i), r = right(i), min = i;
        if (l < heapSize && nums[l] < nums[min])
            min = l;
        if (r < heapSize && nums[r] < nums[min])
            min = r;
        // 若节点 i 最小或索引 l, r 越界，则无须继续堆化，跳出
        if (min == i)
            break;
        // 交换两节点
        swap(nums, i, min);
        // 循环向下堆化
        i = min;
        }
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

// 法三：快排（快速选择）
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
