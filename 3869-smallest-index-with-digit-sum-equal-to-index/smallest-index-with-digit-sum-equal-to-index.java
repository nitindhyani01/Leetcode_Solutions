class Solution {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (digit(nums[i]) == i) {
                return i;
            }
        }
        return -1;
    }

    public int digit(int num) {
        int digit;
        int sum = 0;
        while (num != 0) {
            digit = num % 10;
            sum = sum + digit;
            num = num / 10;
        }
        return sum;
    }
}
