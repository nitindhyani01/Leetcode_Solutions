class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num || sum < 1) {
            return "";
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < num; i++) {
            int cur = Math.min(9, sum);
            res.append(cur);
            sum -= cur;
        }
        if (sum > 0) {
            return "";
        }
        return res.toString();
    }
}