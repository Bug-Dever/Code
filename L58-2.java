class Solution {
    public String dynamicPassword(String password, int target) {
        String post = password.substring(0,target);
        String pre = password.substring(target,password.length());

        StringBuilder sb = new StringBuilder();
        return sb.append(pre).append(post).toString();
    }
}
