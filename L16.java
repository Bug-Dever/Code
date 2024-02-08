// 快速幂
class Solution {
    public double myPow(double x, int n) {
        long nn = n; // 用long暂存，防止2^-31取反后溢出
        double res = 1;
        if(nn<0) {
            nn = -nn;
            x = 1/x;
        }
        while(nn!=0) {
            if((nn&1)==1) 
                res *= x;
            x = x * x;
            nn >>= 1;
        }
        return res;
    }
}
