class Solution {
    public boolean verifyTreeOrder(int[] postorder) {
        return recur(postorder,0,postorder.length-1);
    }

    public boolean recur(int[] postorder,int left, int right) {
        if(left >= right) {
            return true;
        }

        // 找到第一个比根节点大的，此节点右边都是右子树
        int temp1 = left; // 暂存
        while(postorder[temp1] < postorder[right]) {
            temp1++;
        }
        int temp2 = temp1;

        // 判断右子树是否都比根节点值大
        while(temp2 < right) {
            if(postorder[temp2] < postorder[right]) {
                return false;
            }
            temp2++;
        }

        return recur(postorder,left,temp1-1) && recur(postorder,temp1,right-1);
    }
}
