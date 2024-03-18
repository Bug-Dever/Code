class Solution {
    public boolean checkDynasty(int[] places) {
        int min = 14, max = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < places.length; i++) {
            if(places[i] == 0) continue;
            if(set.contains(places[i])) return false;
            min = min < places[i] ? min : places[i];
            max = max > places[i] ? max : places[i];

            set.add(places[i]);
        }
        if(max - min < 5) return true;
        return false;
    }
}
