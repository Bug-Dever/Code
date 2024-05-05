// 法二：答案视角
class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    String s;
    int n;
    public List<List<String>> partition(String s) {
        this.s = s;
        this.n = s.length();
        dfs(0);
        return ans;
    }
    public void dfs(int i) {    
        if(i == n) {
            ans.add(new ArrayList<>(path));
            return;
        }
            
        for(int j = i; j < n; j++) {
            // 枚举 j 作为子串的结束位置
            String t = s.substring(i, j + 1);
            if(isPalindrome(t)) {
                path.add(t);
                dfs(j + 1);
                path.remove(path.size() - 1);
            }   
        }
    }
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++; right--;
        }
        return true;
    }
}
