class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        StringBuilder sb = new StringBuilder();       
        int num = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                // 若c是字母
                sb.append(c);
            } else if(c >= '0' && c <= '9') {
                // 若c是数字
                num = num * 10 + (c - '0');
            } else if(c == '[') {
                // 压入栈
                numStack.push(num);
                strStack.push(sb.toString());
                sb = new StringBuilder(); // 清空sb
                num = 0; // 清零num
            } else if(c == ']') {
                StringBuilder ans = new StringBuilder();
                String string = strStack.pop();
                ans.append(string);
                int iteration = numStack.pop();
                for(int j = 0; j < iteration; j++) {
                    ans.append(sb.toString());
                }
                sb = ans;
                num = 0;
            }
        }
        return sb.toString();  
    }
}
