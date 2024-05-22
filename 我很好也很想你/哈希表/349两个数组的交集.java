class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for(int num : nums1) {
            set.add(num);
        }
        for(int num : nums2) {
            if(set.contains(num))
                res.add(num);
        }
        
        return res.stream().mapToInt(x -> x).toArray();
    }
}
