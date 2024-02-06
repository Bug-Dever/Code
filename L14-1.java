// 数学方式：
// 结论1：平均分乘积大；结论2：以长度3平均分乘积最大
class Solution {
    public int cuttingBamboo(int bamboo_len) {
        if(bamboo_len<=3) return bamboo_len-1;
        int remain = bamboo_len % 3; // 除3的余数
        int res = (bamboo_len-remain)/3; // 除3的商

        if(remain==0) return (int)Math.pow(3,res);
        else if(remain==1) return (int)Math.pow(3,res-1)*4;
        else return (int)Math.pow(3,res)*2;

    }
}
