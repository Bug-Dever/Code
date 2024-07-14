// 双指针，从末尾向前
class Solution {
    public String reverseWords(String s) {
        s = s.trim(); // 去掉首尾空格
        int i = s.length() - 1, j = i; // 规定 i 在左边，j 在右边
        StringBuilder sb = new StringBuilder();
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) != ' ') i--;
            sb.append(s.substring(i + 1, j + 1));
            sb.append(" "); // 添加单词间空格
            while(i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        return sb.toString().trim();
    }
}
