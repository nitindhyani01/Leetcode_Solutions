import java.util.Arrays;

class Solution {
    private static final long MOD = 1_000_000_007L;
    private long[] sum1; 
    private long[] sum2; 
    private long[] lazy; 

    public int sumCounts(int[] nums) {
        int n = nums.length;
        sum1 = new long[4 * n];
        sum2 = new long[4 * n];
        lazy = new long[4 * n];

        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        int[] lastSeen = new int[maxVal + 1];
        Arrays.fill(lastSeen, -1);

        long totalAns = 0;

        for (int i = 0; i < n; i++) {
            int prevIndex = lastSeen[nums[i]];
            lastSeen[nums[i]] = i;

            update(1, 0, n - 1, prevIndex + 1, i, 1);
            totalAns = (totalAns + sum2[1]) % MOD;
        }
        return (int) totalAns;
    }

    private void apply(int node, int start, int end, long val) {
        long len = end - start + 1;
        sum2[node] = (sum2[node] + 2 * val % MOD * sum1[node] + len * val % MOD * val) % MOD;
        sum1[node] = (sum1[node] + len * val) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }

    private void pushDown(int node, int start, int end) {
        if (lazy[node] != 0) {
            int mid = (start + end) >>> 1;
            apply(node * 2, start, mid, lazy[node]);
            apply(node * 2 + 1, mid + 1, end, lazy[node]);
            lazy[node] = 0;
        }
    }

    private void update(int node, int start, int end, int l, int r, int val) {
        if (l <= start && end <= r) {
            apply(node, start, end, val);
            return;
        }
        pushDown(node, start, end);
        int mid = (start + end) >>> 1;
        if (l <= mid) {
            update(node * 2, start, mid, l, r, val);
        }
        if (r > mid) {
            update(node * 2 + 1, mid + 1, end, l, r, val);
        }
        sum1[node] = (sum1[node * 2] + sum1[node * 2 + 1]) % MOD;
        sum2[node] = (sum2[node * 2] + sum2[node * 2 + 1]) % MOD;
    }
}