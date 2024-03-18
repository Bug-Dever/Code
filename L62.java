// 约瑟夫环问题
class Solution {
    public int iceBreakingGame(int num, int target) {
        int i = 0;

        for(int j = 2; j <= num; j++) {
            i = (i + target) % j;
        }
        return i;
    }
}
