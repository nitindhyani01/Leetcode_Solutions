class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) {
                first[c] = i;
            }
            last[c] = i;
        }
        
        List<int[]> intervals = new ArrayList<>();
        
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) continue;
            
            int left = first[i];
            int right = last[i];
            boolean isValid = true;
           
            for (int j = left; j <= right; j++) {
                int c = s.charAt(j) - 'a';
                
                if (first[c] < left) {
                    isValid = false;
                    break;
                }
                
                right = Math.max(right, last[c]);
            }
            
            if (isValid) {
                intervals.add(new int[]{left, right});
            }
        }
        
        Collections.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) return (a[1] - a[0]) - (b[1] - b[0]);
            return a[1] - b[1];
        });
        
        List<String> res = new ArrayList<>();
        int prevEnd = -1;
        
        for (int[] interval : intervals) {
            if (interval[0] > prevEnd) {
                res.add(s.substring(interval[0], interval[1] + 1));
                prevEnd = interval[1];
            }
        }
        return res;
    }
}