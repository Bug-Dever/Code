// 手写一个小顶堆实现
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // 统计各个数字出现的次数
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 获取nums中有几种不同的数字
        int size = map.keySet().size();
        int[] keys = new int[size];
        int j = 0;
        for(Integer v : map.keySet()) {
            keys[j++] = v;
        }
        buildMinHeap(keys, k);
        for(int i = k; i < keys.length; i++) {
            if(map.get(keys[i]) > map.get(keys[0])) {
                keys[0] = keys[i];
                minHeapify(keys, k, 0);
            }
        }
        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = keys[i];
        }
        return ans;
    }

    void buildMinHeap(int[] nums, int heapSize) {
        for(int i = parent(heapSize - 1); i >= 0; i--) {
            minHeapify(nums, heapSize, i);
        }
    }

    void minHeapify(int[] nums, int heapSize, int i) {
        int l = left(i), r = right(i), min = i;
        while(true) {
            if(l < heapSize && nums[l] < nums[min]) {
                min = l;
            }
            if(r < heapSize && nums[r] < nums[min]) {
                min = r;
            }
            if(min == i)
                break;
            swap(nums, min, i);
            i = min;
        }
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
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }    

}
