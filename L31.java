class Solution {
    public boolean validateBookSequences(int[] putIn, int[] takeOut) {
        Stack<Integer> s = new Stack<>(); // 构造辅助栈
        int j = 0;
        for(int i : putIn) {
            s.push(i);
            while(!s.isEmpty() && s.peek() == takeOut[j]) {
                s.pop();
                j++;
            }
        }
        return s.isEmpty();
    }
}
