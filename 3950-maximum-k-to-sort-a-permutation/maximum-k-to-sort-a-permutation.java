class Solution {
    public int sortPermutation(int[] nums) {
        int k = -1;
        boolean hasMisplaced = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                if (!hasMisplaced) {
                    k = nums[i];
                    hasMisplaced = true;
                } else {
                    k &= nums[i];
                }
            }
        }
        return hasMisplaced ? k : 0;
    }
}