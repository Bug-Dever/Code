class Solution {
    public int takeAttendance(int[] records) {
        return binarySearch(records);
    }
    public int binarySearch(int[] records) {
        int left = 0, right = records.length - 1, mid;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(records[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
