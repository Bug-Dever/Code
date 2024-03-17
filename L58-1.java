// 法一：用 trim() 和 split() 函数
class Solution {
    public String reverseMessage(String message) {
        String[] str = message.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = str.length - 1; i >= 0; i--) {
            if(str[i] == "") continue;
            sb.append(str[i] + " ");
        }
        return sb.toString().trim();
    }
}

// 法二： 用两个指针确定一个单词的位置
class Solution {
    public String reverseMessage(String message) {
        if(message == null || message.length() <= 0){
            return message;
        }
        message = message.trim();
        StringBuilder sb = new StringBuilder();
        int i = message.length() - 1, j = i;
        
        while(i >= 0) {
            while(i >= 0 && message.charAt(i) != ' ') i--; // 找到单词的开头
            sb.append(message.substring(i+1, j+1) + " "); // 由于是左闭右开，故j+1
            while(i >= 0 && message.charAt(i) == ' ') i--; // 处理两个单词间的空格
            j = i;
        }

        return sb.toString().trim();
    }
}
