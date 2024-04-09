// 二分查找的几种写法
// 1. 最原始的查找指定的元素的index (适用于数组有序、不重复)
int binarySearch(int[] nums, int target) {
    int left = 0, right = nums.length - 1, mid;
    while(left <= right) {
        mid = left + (right - left) / 2; // 防溢出
        if(nums[mid] < target) {
            left = mid + 1;
        } else if(nums[mid] > target) {
            right = mid - 1;
        } else {
            return mid;
        }
    }
    return -1;
}


// 2. 查找插入点位置(lower_bound)
//   2.1. target仅存在一个
int lower_bound(int[] nums, int target) {
    int left = 0, right = nums.length - 1, mid;
    while(left <= right) {
        mid = left + (right - left) / 2;
        if(nums[mid] < target) {
            left = mid + 1;
        } else if(nums[mid] > target) {
            right = mid - 1;
        } else {
            return mid; // 找到 target，返回插入点 mid
        }
    }
    return left; // 未找到 target，返回插入点left
}

//   2.2. target存在多个
//     2.2.1. 闭区间写法
int lower_bound(int[] nums, int target) {
    int left = 0, right = nums.length - 1, mid; // 闭区间[left, right]
    while(left <= right) {
        mid = left + (right - left) / 2;
        if(nums[mid] < target) {
            left = mid + 1; // [mid + 1, right]
        } else if(nums[mid] > target) {
            right = mid - 1;  // [left, mid - 1]
        } else {
            right = mid - 1; // 首个小于 target 的元素在区间 [i, mid-1] 中，可以与上面的nums[mid] > target情况合并
        }
    }
    return left; // 未找到 target，返回插入点left
}
//     2.2.2. 左闭右开区间写法
int lower_bound(int[] nums, int target) {
    int left = 0, right = nums.length, mid; // 左闭右开区间[left, right)
    while(left < right) {
        mid = left + (right - left) / 2;
        if(nums[mid] < target) {
            left = mid + 1; // [mid + 1, right)
        } else {
            right = mid; // [left, mid)
        }
    }
    return left; // 或者return right都行
}
//     2.2.3. 开区间写法
int lower_bound(int[] nums, int target) {
    int left = -1, right = nums.length, mid; // 左闭右开区间(left, right)
    while(left + 1 < right) {
        mid = left + (right - left) / 2;
        if(nums[mid] < target) {
            left = mid; // (mid, right)
        } else {
            right = mid; // (left, mid)
        }
    }
    return right; // 或者return right都行
}

// 以上都是>=target的第一个位置，当处理>, <, <=时，需转换问题：
// >x 换成 (>=x+1)
// <x 换成 (>=x) -1
// <=x 换成 (>=x+1) -1

相关题目：
34. 在排序数组中查找元素的第一个和最后一个位置
162. 寻找峰值
153. 寻找旋转排序数组中的最小值
33. 搜索旋转排序数组
