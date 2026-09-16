class Solution {
    public int numberOfSets(int n, int K) {
        int MOD = 1_000_000_007;
        int[][] dp = new int[K + 1][n];
     
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1; 
        }
        
        for (int k = 1; k <= K; k++) {
            long runningSum = 0;
            for (int i = n - 2; i >= 0; i--) {
                runningSum = (runningSum + dp[k - 1][i + 1]) % MOD;
                int skip = dp[k][i + 1];
                int take = (int) runningSum;
                dp[k][i] = (int)((take + (long)skip) % MOD);
            }
        }
        
        return dp[K][0];
    }
}