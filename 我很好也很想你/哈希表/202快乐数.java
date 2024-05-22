class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(!set.contains(n)) {
            int sum = 0;
            set.add(n);
            while(n > 0) {
                int res = n % 10;
                sum += res * res;
                n /= 10;
            }
            n = sum;
            if(sum == 1) {
                return true;
            }
        }
        return false;
    }
}
