class Solution {
    public int[][] fileCombination(int target) {
        int i = 1, j = 2, sum = 3;
        List<int[]> res = new ArrayList<>();
        while(i < j) {
            if(sum < target) {
                j++;
                sum += j; 
            } else if(sum > target) {
                sum -= i;
                i++;
            } else {
                // sum = target
                int[] arr = new int[j-i+1];
                for(int k = i; k <= j; k++) {
                    arr[k - i] = k;
                }
                res.add(arr);
                sum -= i;
                i++;
            }
        }
        return res.toArray(new int[0][]);
    }
}
