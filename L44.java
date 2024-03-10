class Solution {
    public int findKthNumber(int k) {
        // digit: 1->个 2->十
        long num = 9;
        int digit = 1;
        long charNum = num;
        while(k > charNum) {
            k = (int) (k - charNum);
            digit = digit + 1;
            num = num * 10;
            charNum = num * digit;
        }
        // 此时digit即为数字所在的范围 k即为该范围内剩下的数字个数
        int start = (int) Math.pow(10,digit-1);
        // 确定在哪个数上
        int res = start + (k - 1) / digit;
        // 确定在这个数的第几位
        int index = (k - 1) % digit + 1;
        
        return Integer.toString(res).charAt(index - 1) - '0';
    
    }
}
