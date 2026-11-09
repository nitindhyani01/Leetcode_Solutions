class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] count = new int[k];
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }
        int n = arrival.length;
        for (int i = 0; i < n; i++) {
            int start = arrival[i];
            int duration = load[i];
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                available.add(busy.poll()[1]);
            }
            if (available.isEmpty()) {
                continue;
            }
            Integer server = available.ceiling(i % k);
            if (server == null) {
                server = available.first();
            }
            available.remove(server);
            busy.offer(new int[]{start + duration, server});
            count[server]++;
        }
        int maxRequests = 0;
        for (int c : count) {
            maxRequests = Math.max(maxRequests, c);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == maxRequests) {
                result.add(i);
            }
        }        
        return result;
    }
}