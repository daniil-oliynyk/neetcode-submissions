class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        ArrayList<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int[] interval : intervals) {
            int[] last = res.get(res.size()-1);
            int lastEnd = last[1];
            if (interval[0]<= lastEnd) {
                lastEnd = Math.max(lastEnd,interval[1]);
                last[1] = lastEnd;
            } else {
                res.add(interval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
