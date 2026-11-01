class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;

        long sum = 0;
        int minEl = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            minEl = Math.min(minEl, nums[i]);
        }
        return (int) (sum - (long) n * minEl);
    }
}