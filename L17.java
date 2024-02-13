// 从1打印到最大的n位，考虑大数问题(超出int类型表示范围2^31-1)
class Solution {
    int[] res;
    int nine = 0, cnt, start;
    int count = 0;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public int[] countNumbers(int cnt) {
        this.cnt = cnt;
        start = cnt - 1;
        num = new char[cnt];
        res = new int[(int)Math.pow(10,cnt)-1];
        dfs(0);
        //res.deleteCharAt(res.length()-1); // 删除最后的,
        return res;
    }
    void dfs(int x) {
        if(x == cnt) {
            String s = String.valueOf(num).substring(start);
            if(!s.equals("0")) res[count++] = Integer.parseInt(s);
            if(cnt-start==nine) start--;
            return;
        }
        for(char i : loop) {
            num[x] = i;
            if(i=='9') nine++;
            dfs(x+1);
        }
        nine--;
    }
}
