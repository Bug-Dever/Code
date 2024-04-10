// 单调栈，从右往左
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i = n - 1; i >= 0; i--) {
            while(!s.isEmpty() && temperatures[i] >= temperatures[s.peek()]) {
                s.pop();
            }
            ans[i] = s.isEmpty() ? 0 : s.peek() - i;            
            s.push(i);
        }
        return ans;
    }
}

// 从左到右
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                int j = s.pop();
                ans[j] = i - j;
            }          
            s.push(i);
        }
        return ans;
    }
}
