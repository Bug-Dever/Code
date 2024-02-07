// 巧用n&(n-1)消去最右边的1
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0; // 记录1的个数
        while(n!=0) {
            n=n&(n-1);
            count++;
        }
        return count;
    }
}
