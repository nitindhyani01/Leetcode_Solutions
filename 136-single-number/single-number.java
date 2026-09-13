class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j]) {
                    swap(nums, i, j);
                }
            }
        } 
        for (int k = 0; k < nums.length - 1; k += 2) {
            if (nums[k] != nums[k + 1]) {
                return nums[k]; 
            }
        } 
        return nums[nums.length - 1];
    } 

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i]; 
        nums[i] = nums[j]; 
        nums[j] = temp; 
    } 
}