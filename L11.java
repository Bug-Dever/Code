class Solution {
    public int stockManagement(int[] stock) {
        int i = 0, j = stock.length-1, m;
        while(i<j) {
            m = (i+j)/2;
            if(stock[m]<stock[j]) j=m;
            else if(stock[m]>stock[j]) i=m+1;
            else j--;
        }
        return stock[i];
    }
}
