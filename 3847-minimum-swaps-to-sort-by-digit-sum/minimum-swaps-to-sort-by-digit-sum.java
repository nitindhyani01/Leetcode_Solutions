class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][3];
        
        for (int i = 0; i < n; i++) {
            arr[i][0] = getDigitSum(nums[i]);
            arr[i][1] = nums[i];
            arr[i][2] = i;
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        boolean[] visited = new boolean[n];
        int swaps = 0;
        
        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i][2] == i) {
                continue;
            }
            
            int cycleSize = 0;
            int curr = i;
            
            while (!visited[curr]) {
                visited[curr] = true;
                curr = arr[curr][2];
                cycleSize++;
            }
            
            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }
        
        return swaps;
    }
    
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}