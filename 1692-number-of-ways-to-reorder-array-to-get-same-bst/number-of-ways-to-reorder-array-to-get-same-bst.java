class Solution {
    private static final long MOD = 1_000_000_007;
    private long[][] triangle;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        
        triangle = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            triangle[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                triangle[i][j] = (triangle[i - 1][j - 1] + triangle[i - 1][j]) % MOD;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        return (int) ((dfs(list) - 1 + MOD) % MOD);
    }

    private long dfs(List<Integer> nums) {
        int m = nums.size();
        if (m <= 2) {
            return 1;
        }

        int root = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < m; i++) {
            if (nums.get(i) < root) {
                left.add(nums.get(i));
            } else {
                right.add(nums.get(i));
            }
        }

        long leftWays = dfs(left);
        long rightWays = dfs(right);
        long waysToInterleave = triangle[m - 1][left.size()];

        return (((waysToInterleave * leftWays) % MOD) * rightWays) % MOD;
    }
}