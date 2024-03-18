// 利用 && || 短路的性质 实现递归 从而避免使用if
class Solution {
    public int mechanicalAccumulator(int target) {
        
        boolean x = target > 1 && (target += mechanicalAccumulator(target - 1)) > 0;
        return target;
    }
}
