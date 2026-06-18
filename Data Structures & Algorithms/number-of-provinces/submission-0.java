class Solution {
    int n;
    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        int ans = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, i, visited);
                ans++;
            }
        }
        return ans;
    }

    public void dfs(int[][] isConnected, int i, boolean[] visited) {
        visited[i] = true;
        for (int nbr = 0; nbr < n; nbr++) {
            if (isConnected[i][nbr] == 1 && !visited[nbr]) dfs(isConnected, nbr, visited);
        }
    }
}