class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] bitCounts = new int[30];
        
        for (int num : nums) {
            for (int i = 0; i < 30; i++) {
                if ((num & (1 << i)) != 0) {
                    bitCounts[i]++;
                }
            }
        }        
        long totalSum = 0;
        long mod = 1_000_000_007;

        for (int step = 0; step < k; step++) {
            long currentNum = 0;
            for (int i = 0; i < 30; i++) {
                if (bitCounts[i] > 0) {
                    currentNum |= (1L << i);
                    bitCounts[i]--;
                }
            }
            totalSum = (totalSum + (currentNum * currentNum) % mod) % mod;
        }        
        return (int) totalSum;
    }
}