class Solution {
    public int findNumbers(int[] nums) {
            int count=0;
            for(int number:nums){
                if(Even(number)){
                    count++;
                }
            }
            return count;
      }
    int numberOfDigits(int nums){
            int count=0;
            while(nums!=0){
                nums=nums/10;
                count++;
            }
            return count;
        }

    boolean Even(int nums){
        return numberOfDigits(nums)%2==0;
        }
}