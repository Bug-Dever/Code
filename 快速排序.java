void quickSort(int[] nums, int left, int right) {
    if(left >= right) {
        return;
    }
    // 哨兵划分
    int pivot = partition(nums, left, right);

    quickSort(nums, left, pivot-1);
    quickSort(nums, pivot+1, right);

    
}
int partition(int[] nums, int left, int right) {
    int i = left, j = right;
    while(i < j) {
        while(i < j && nums[j] >= nums[right])
            j--;
        while(i < j && nums[i] <= nums[left])
            i++;
        // 交换
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    // 交换头和第i个
    temp = nums[i];
    nums[i] = nums[left];
    nums[left] = temp;
    return i;
}
