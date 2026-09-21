class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] prevDp = new long[k];
        for (int num : nums) {
            long[] currDp = new long[k];
            int val = num % k;
            currDp[val]++;
            for (int r = 0; r < k; r++) {
                if (prevDp[r] > 0) {
                    int nextR = (r * val) % k;
                    currDp[nextR] += prevDp[r];
                }
            }
            for (int r = 0; r < k; r++) {
                result[r] += currDp[r];
            }
            prevDp = currDp;
        }
        return result;
    }
}