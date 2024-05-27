// 双指针 从末尾向前
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int i = s.length() - 1, j = i;
        StringBuilder sb = new StringBuilder();
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) != ' ') i--;
            sb.append(s.substring(i + 1, j + 1) + " ");
            
            while(i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        return sb.toString().trim();
    }
}
