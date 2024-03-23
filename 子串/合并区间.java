class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        // 按第一个元素升序排序
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        for(int i = 0; i < intervals.length; i++) {
            if(list.size() == 0 || intervals[i][0] > list.get(list.size()-1)[1]) {
                list.add(intervals[i]);
            } else {
                // 可以合并的情况
                list.get(list.size()-1)[1] = Math.max(intervals[i][1], list.get(list.size()-1)[1]);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
