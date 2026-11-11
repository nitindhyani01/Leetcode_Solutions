class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if (costBoth < cost1 + cost2) {
            long bothNeeded = Math.min(need1, need2);
            long totalCost = bothNeeded * costBoth;
            
            need1 -= bothNeeded;
            need2 -= bothNeeded;
            if (need1 > 0) {
                totalCost += need1 * Math.min((long)cost1, (long)costBoth);
            }
            if (need2 > 0) {
                totalCost += need2 * Math.min((long)cost2, (long)costBoth);
            }
            return totalCost;
        } else {
            return (long)need1 * cost1 + (long)need2 * cost2;
        }
    }
}