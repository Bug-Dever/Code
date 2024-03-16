class Solution {
    public int[] twoSum(int[] price, int target) {
        int i = 0, j = price.length - 1;
        while(i < j) {
            if(price[i] + price[j] > target) {
                j--;
            } else if(price[i] + price[j] < target) {
                i++;
            } else {
                return new int[]{price[i], price[j]};
            }
        }
        return new int[0];
    }
}
