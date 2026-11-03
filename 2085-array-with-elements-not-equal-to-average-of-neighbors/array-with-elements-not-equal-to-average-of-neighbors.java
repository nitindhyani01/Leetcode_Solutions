class Solution {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        
        int n = nums.length;
        int[] res = new int[n];
        
        int left = 0;
        int right = n - 1;
        int idx = 0;
        while (left <= right) {
            if (idx % 2 == 0) {
                res[idx++] = nums[left++];
            } else {
                res[idx++] = nums[right--];
            }
        }       
        return res;
    }
}