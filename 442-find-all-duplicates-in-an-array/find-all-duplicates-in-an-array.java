class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int i = 1;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                swap(nums, correct, i);
            } else {
                i++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1) {
                ans.add(nums[index]);
            }
        }
        return ans;
    }

    public void swap(int[] arr, int i, int correct) {
        int temp;
        temp = arr[i];
        arr[i] = arr[correct];
        arr[correct] = temp;
    }
}