class Solution {
    Integer[] dp;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        ArrayList<int[]> jobs = new ArrayList<>();

        for (int i = 0; i < profit.length; i++) jobs.add(new int[]{startTime[i], endTime[i], profit[i]});

        Collections.sort(jobs, (a, b) -> a[0] - b[0]);
        dp = new Integer[jobs.size() + 1];

        return recur(jobs, 0);
    }

    public int recur(ArrayList<int[]> jobs, int i) {
        if (i >= jobs.size() || i < 0) return 0;

        if (dp[i] != null) return dp[i];

        int nextIdx = getNextIdx(jobs, jobs.get(i)[1]);
        int pick = jobs.get(i)[2] + recur(jobs, nextIdx);

        int skip = recur(jobs, i + 1);

        return dp[i] = Math.max(pick, skip);
    }

    public int getNextIdx(ArrayList<int[]> jobs, int target) {
        int l = 0, r = jobs.size();

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (jobs.get(mid)[0] < target) l = mid + 1;
            else r = mid;
        }
        return l == jobs.size() ? -1 : l;
    }
}