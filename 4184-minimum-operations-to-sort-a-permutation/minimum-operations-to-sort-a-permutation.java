class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        int idx0 = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                idx0 = i;
                break;
            }
        }

        boolean isInc = true;
        for (int i = 0; i < n; i++) {
            if (nums[(idx0 + i) % n] != i) {
                isInc = false;
                break;
            }
        }

        if (isInc) {
            int cost1 = idx0;
            int cost2 = 2 + (n - idx0) % n;
            return Math.min(cost1, cost2);
        }

        boolean isDec = true;
        for (int i = 0; i < n; i++) {
            if (nums[(idx0 - i + n) % n] != i) {
                isDec = false;
                break;
            }
        }

        if (isDec) {
            int cost1 = 1 + (n - 1 - idx0);

            int cost2 = 1 + (idx0 + 1) % n;
            return Math.min(cost1, cost2);
        }
        return -1;
    }
}