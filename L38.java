// 回溯 剪枝
class Solution {
    boolean[] visited;
    List<Character> path;
    List<String> res;

    public String[] goodsOrder(String goods) {
        this.visited = new boolean[goods.length()];
        this.path = new ArrayList<>();
        this.res = new ArrayList<>();
        char[] arr = goods.toCharArray();
        Arrays.sort(arr); // 将相同的字母放在一起，这样在重复时候就能和前一个进行比较
        dfs(arr, 0);
        String[] s = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            s[i] = res.get(i);
        }
        return s;
    }

    public void dfs(char[] arr, int k) {
        if (k == arr.length) {
            res.add(listToString(path));
            return;
        }

        // 进行N叉树搜索
        for (int i = 0; i < arr.length; i++) {
            // 剪枝
            if (i > 0 && arr[i] == arr[i - 1] && visited[i - 1] == false) {
                continue;
            }

            if (visited[i] == false) {
                // 没有被搜索过
                visited[i] = true;
                path.add(arr[i]);

                dfs(arr, k + 1);

                // 回退
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public String listToString(List<Character> list) {
        StringBuffer b = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            b.append(list.get(i));
        }
        return b.toString();
    }
}
