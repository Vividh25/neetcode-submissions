/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        int n = intervals.size();
        if (n == 0) return true;
        int overlaps = 0;
        intervals.sort(Comparator.comparingInt((Interval i) -> i.start)
                         .thenComparingInt(i -> i.end));

        int i = 0;
        
        while (i < n - 1) {
            if (intervals.get(i).end > intervals.get(i + 1).start) return false;
            i++;
        } 
        return true;
    }
}
