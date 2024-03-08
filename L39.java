// 摩尔投票法
class Solution {
    public int inventoryManagement(int[] stock) {
        int target = stock[0], vote = 1;
        for(int i = 1; i < stock.length; i++) {
            if(vote == 0) {
                target = stock[i];
            }
            if(target == stock[i]) {
                vote++;
            } else {
                vote--;
            }
        }
        return target;
    }
}
