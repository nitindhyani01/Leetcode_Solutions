class Solution {
    public int findClosestNumber(int[] nums) {
        int closest = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int currentDist = getAbsoluteValue(nums[i]);
            int closestDist = getAbsoluteValue(closest);
            
            if (currentDist < closestDist) {
                closest = nums[i];
            } else if (currentDist == closestDist && nums[i] > closest) {
                closest = nums[i];
            }
        }
    
        return closest;
    }
    
    private int getAbsoluteValue(int n) {
        if (n < 0) {
            return -n;
        }
        return n;
    }
}