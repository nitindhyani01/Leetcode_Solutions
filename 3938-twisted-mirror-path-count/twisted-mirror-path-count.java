class Solution {
    private static final int MOD = 1_000_000_007;

    public int uniquePaths(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] memo = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j][0] = -2;
                memo[i][j][1] = -2;
            }
        }

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) continue;

                int rightTarget = getTarget(grid, i, j + 1, 0, memo);
                if (rightTarget != -1) {
                    int r = rightTarget / n, c = rightTarget % n;
                    dp[r][c] = (dp[r][c] + dp[i][j]) % MOD;
                }

                int downTarget = getTarget(grid, i + 1, j, 1, memo);
                if (downTarget != -1) {
                    int r = downTarget / n, c = downTarget % n;
                    dp[r][c] = (dp[r][c] + dp[i][j]) % MOD;
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    private int getTarget(int[][] grid, int r, int c, int d, int[][][] memo) {
        int m = grid.length, n = grid[0].length;
        if (r < 0 || r >= m || c < 0 || c >= n) return -1;
        if (grid[r][c] == 0) return r * n + c;
        if (memo[r][c][d] != -2) return memo[r][c][d];

        int res;
        if (d == 0) {
            res = getTarget(grid, r + 1, c, 1, memo);
        } else {
            res = getTarget(grid, r, c + 1, 0, memo);
        }
        return memo[r][c][d] = res;
    }
}