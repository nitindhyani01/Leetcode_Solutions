class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int index=0;
        while(index<nums.length-1){
            if(nums[index]==nums[index+1]){
                return true;
            }
            index++;
        }
        return false;
    }
}