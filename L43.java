// 0~num
class Solution {
    public int digitOneInNumber(int num) {
        int high = num / 10;
        int cur = num % 10;
        int low = 0;
        int digit = 1;
        // 记录结果数
        int res = 0;
        while(high != 0 || cur != 0) {
            if(cur == 0) {
                res += high * digit;
            } else if(cur == 1) {
                res += high * digit + low + 1;
            } else {
                res += (high + 1) * digit;
            }
            // 更新high cur low dight 注意更新的顺序有要求的!!
            low = low + digit * cur;
            cur = high % 10;
            high = high / 10;
            digit = digit * 10;
        }
        return res;
    }
}
