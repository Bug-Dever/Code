// 定义dfs函数(作用是选第i个及以后的元素)
// 2024.04.30
class Solution {
    int n;
    List<String> ans = new ArrayList<>();
    char[] path, digits;
    String[] MAPPING = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        n = digits.length();
        if(n == 0)
            return new ArrayList<String>();
        path = new char[n];
        this.digits = digits.toCharArray();
        dfs(0);
        return ans;
    }
    public void dfs(int i) {
        if(i == n) {
            ans.add(new String(path));
            return;
        }
        for(char c : MAPPING[digits[i] - '0'].toCharArray()) {
            path[i] = c;
            dfs(i + 1);
        }
    }
}
