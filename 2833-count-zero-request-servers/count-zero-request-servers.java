class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = queries.length;
        int[][] sortedQueries = new int[m][2];
        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        
        java.util.Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        java.util.Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        
        int[] ans = new int[m];
        java.util.HashMap<Integer, Integer> serverCount = new java.util.HashMap<>();
        
        int left = 0, right = 0;
        int logLen = logs.length;
        
        for (int i = 0; i < m; i++) {
            int qTime = sortedQueries[i][0];
            int qIdx = sortedQueries[i][1];
            int windowStart = qTime - x;
            int windowEnd = qTime;
            while (right < logLen && logs[right][1] <= windowEnd) {
                int serverId = logs[right][0];
                serverCount.put(serverId, serverCount.getOrDefault(serverId, 0) + 1);
                right++;
            }
            while (left < logLen && logs[left][1] < windowStart) {
                int serverId = logs[left][0];
                serverCount.put(serverId, serverCount.get(serverId) - 1);
                if (serverCount.get(serverId) == 0) {
                    serverCount.remove(serverId);
                }
                left++;
            }
            ans[qIdx] = n - serverCount.size();
        }
        return ans;
    }
}