class Solution {
    public int trainingPlan(int[] actions) {
        int[] arr = new int[32]; // int有32位
        int digit = 1; // 指示位数
        int sum = 0;
        for(int i = 0; i < 32; i++) {
            for(int j = 0; j < actions.length; j++) {
                if((actions[j] & digit) != 0) {
                    arr[i]++;
                }
            }
            arr[i] = arr[i] % 3;
            sum += arr[i] * digit;
            digit = digit << 1;
        }
        return sum;
    }
}
