class Solution {
    public int[] sockCollocation(int[] sockets) {
        int z = 0;
        for(int num : sockets) {
            z ^= num;  // z = x ^ y 
        }
        // 循环左移，计算m，m指向x和y二进制中最低的那位不相等的数
        int m = 1;
        while((z & m) == 0) {
            m <<= 1;
        }
        // 分成两组子数组
        int x = 0, y = 0;
        for(int num : sockets) {
            if((num & m) == 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        return new int[]{x, y};
    }
}
