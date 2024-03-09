// 时间复杂度O(n) n+n/2+n/4+...+1 = 2n
class Solution {
    public int[] inventoryManagement(int[] stock, int cnt) {
        // 处理特殊情况
        if(stock == null || stock.length == 0 || cnt == 0) {
            return new int[0];
        }

        return quickFind(stock,0,stock.length - 1,cnt);
        
    }
    int[] quickFind(int[] arr, int left, int right, int k) {
        int pivot = partition(arr, left, right);

        if(pivot+1 == k) {
            return Arrays.copyOf(arr, k);
        } else if(pivot+1 > k) {
            return quickFind(arr, 0, pivot - 1, k);
        } else {
            return quickFind(arr, pivot + 1, right, k);
        }
    }
    int partition(int[] nums, int left, int right) {
        int i = left, j = right;
        while(i < j) {
            while(i < j && nums[j] >= nums[left])
                j--;
            while(i < j && nums[i] <= nums[left])
                i++;

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

        }
        int temp = nums[left];
        nums[left] = nums[j];
        nums[j] = temp;

        return i;
    }
}
