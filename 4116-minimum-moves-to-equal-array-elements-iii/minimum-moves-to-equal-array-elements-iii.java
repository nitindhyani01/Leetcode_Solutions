class Solution {
    public int minMoves(int[] nums) {
        int max = nums[0];
        int sum = 0;
        
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            sum += num;
        }
        return (max * nums.length) - sum;
    }
}