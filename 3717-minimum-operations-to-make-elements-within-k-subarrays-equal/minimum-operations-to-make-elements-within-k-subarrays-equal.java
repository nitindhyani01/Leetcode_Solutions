class Solution {
    static class SlidingWindowCost {
        private final TreeMap<Integer, Integer> left = new TreeMap<>();
        private final TreeMap<Integer, Integer> right = new TreeMap<>();
        private int leftSize = 0;
        private int rightSize = 0;
        private long leftSum = 0;
        private long rightSum = 0;
        private final int kLeft;
        private final int kRight;

        public SlidingWindowCost(int windowSize) {
            this.kLeft = (windowSize + 1) / 2;
            this.kRight = windowSize / 2;
        }

        private void add(TreeMap<Integer, Integer> map, int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        private void remove(TreeMap<Integer, Integer> map, int val) {
            int count = map.get(val);
            if (count == 1) {
                map.remove(val);
            } else {
                map.put(val, count - 1);
            }
        }

        public void insert(int val) {
            if (left.isEmpty() || val <= left.lastKey()) {
                add(left, val);
                leftSum += val;
                leftSize++;
            } else {
                add(right, val);
                rightSum += val;
                rightSize++;
            }
            balance();
        }

        public void erase(int val) {
            if (!left.isEmpty() && val <= left.lastKey()) {
                remove(left, val);
                leftSum -= val;
                leftSize--;
            } else {
                remove(right, val);
                rightSum -= val;
                rightSize--;
            }
            balance();
        }

        private void balance() {
            while (leftSize > kLeft) {
                int val = left.lastKey();
                remove(left, val);
                leftSum -= val;
                leftSize--;

                add(right, val);
                rightSum += val;
                rightSize++;
            }
            while (leftSize < kLeft && rightSize > 0) {
                int val = right.firstKey();
                remove(right, val);
                rightSum -= val;
                rightSize--;

                add(left, val);
                leftSum += val;
                leftSize++;
            }
        }

        public long getCost() {
            long median = left.lastKey();
            long leftCost = median * leftSize - leftSum;
            long rightCost = rightSum - median * rightSize;
            return leftCost + rightCost;
        }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] windowCost = new long[n + 1];

        SlidingWindowCost sw = new SlidingWindowCost(x);
        for (int i = 0; i < n; i++) {
            sw.insert(nums[i]);
            if (i >= x) {
                sw.erase(nums[i - x]);
            }
            if (i >= x - 1) {
                windowCost[i + 1] = sw.getCost();
            }
        }

        long INF = Long.MAX_VALUE / 2;
        long[] prev = new long[n + 1];
        long[] curr = new long[n + 1];
        Arrays.fill(prev, 0);

        for (int j = 1; j <= k; j++) {
            Arrays.fill(curr, INF);
            for (int i = j * x; i <= n; i++) {
                curr[i] = curr[i - 1];
                if (prev[i - x] != INF) {
                    curr[i] = Math.min(curr[i], prev[i - x] + windowCost[i]);
                }
            }
            System.arraycopy(curr, 0, prev, 0, n + 1);
        }
        return prev[n];
    }
}