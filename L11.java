class Solution {
    public int trainWays(int num) {
        if(num == 0) {
            return 1;
        }
        if(num == 1 || num == 2) {
            return num;
        }
        int a = 1, b = 2, temp = -1;
        for(int i = 3; i <= num; i++) {
            temp = (a + b) % 1000000007;
            a = b;
            b = temp;
        }
        return temp;
    }
}
