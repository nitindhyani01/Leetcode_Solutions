class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int maxFactor = 1500;
        int[] freq = new int[maxFactor + 1];
        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            freq[item[0]]++;
            minPrice = Math.min(minPrice, item[1]);
        }

        int[] divisibleCount = new int[maxFactor + 1];
        for (int f = 1; f <= maxFactor; f++) {
            for (int multiple = f; multiple <= maxFactor; multiple += f) {
                divisibleCount[f] += freq[multiple];
            }
        }

        int[] dp = new int[budget + 1];
        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];
            int gain = divisibleCount[factor];

            for (int b = budget; b >= price; b--) {
                dp[b] = Math.max(dp[b], dp[b - price] + gain);
            }
        }

        for (int b = minPrice; b <= budget; b++) {
            dp[b] = Math.max(dp[b], dp[b - minPrice] + 1);
        }
        return dp[budget];
    }
}