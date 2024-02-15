// 快排的思想————双指针
class Solution {
    public int[] trainingPlan(int[] actions) {
        int i = 0, j = actions.length-1;
        while(i<j) {
            // 从左到右找第一个偶数
            while(i<j && actions[i]%2 != 0) {
                i++;
            }
            // 从右到左找第一个奇数
            while(i<j && actions[j]%2 == 0) {
                j--;
            }
            swap(actions,i,j);
        }
        return actions;
    }
    void swap(int[]num, int x, int y) {
        int temp = num[x];
        num[x] = num[y];
        num[y] = temp;
    }
}
