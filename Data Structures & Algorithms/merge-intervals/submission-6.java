class Solution {
    public int[][] merge(int[][] intervals) {
        int i = 1;
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;

        if (n == 1) return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] newInt = new int[2];
        newInt[0] = intervals[0][0];
        newInt[1] = intervals[0][1];

        while (i < n) {
            if (newInt[1] >= intervals[i][0]) {
                newInt[1] = Math.max(intervals[i][1], newInt[1]);
            }
            else {
                ans.add(newInt);
                newInt = intervals[i];
            }
            i++;
        }
        ans.add(newInt);
        
        return ans.toArray(new int[ans.size()][]);
    }
}
