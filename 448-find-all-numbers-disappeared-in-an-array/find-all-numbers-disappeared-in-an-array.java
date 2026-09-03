class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 1;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
        
        List<Integer> missing =new ArrayList<>();
        for(int index=0;index<nums.length;index++){
            if(nums[index]!= index+1){
                missing.add(index+1);
            }
        }
        return missing;
    }

    public void swap(int[] nums, int i, int correct) {
        int temp;
        temp = nums[i];
        nums[i] = nums[correct];
        nums[correct] = temp;
    }
}