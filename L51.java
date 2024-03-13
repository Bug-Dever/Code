// 归并排序模板
class Solution {
    int count = 0;
    public int reversePairs(int[] record) {
        mergeSort(record, 0, record.length - 1);
        return count;
    }
    public void mergeSort(int[] arr, int left, int right) {
        if(left >= right)
            return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
    public void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while(i <= mid && j <= right) {
            if(arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += (mid - i + 1); // 统计逆序对
            }
        }
        while(i <= mid) {
            temp[k++] = arr[i++];
        }
        while(j <= right) {
            temp[k++] = arr[j++];
        }
        for(k = 0; k < temp.length; k++) {
            arr[left + k] = temp[k];
        }
    }
}
