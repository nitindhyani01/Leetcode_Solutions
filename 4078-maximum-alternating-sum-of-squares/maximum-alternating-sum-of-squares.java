class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] squares = new long[n];
        
        for (int i = 0; i < n; i++) {
            long val = nums[i];
            squares[i] = val * val;
        }
        
        Arrays.sort(squares);
        
        int k = n / 2; 
        long ans = 0;
        
        for (int i = 0; i < n; i++) {
            if (i < k) {
                ans -= squares[i];
            } else {
                ans += squares[i];
            }
        }
        return ans;
    }
}