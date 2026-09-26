class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int n = s.length();
        
        while (i < n) {
            char c = s.charAt(i);
            if (c == '(') {
                int start = i + 1;
                int end = start;
                while (s.charAt(end) != ')') {
                    end++;
                }
                String key = s.substring(start, end);
                sb.append(map.getOrDefault(key, "?"));
                i = end + 1;
            } else {
                sb.append(c);
                i++;
            }
        }
        return sb.toString();
    }
}