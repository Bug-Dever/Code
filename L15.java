public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n / 2 != 0) {
            // 余数不为0，个数加1
            if(n % 2 != 0) {
                count++;
            }
            n = n / 2;
        }
        return (count+1);
    }
}
