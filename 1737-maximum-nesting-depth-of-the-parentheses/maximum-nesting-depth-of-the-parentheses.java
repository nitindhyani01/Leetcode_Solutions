class Solution {
    public int maxDepth(String s) {
        int maxDpt = 0;
        int currDpt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                currDpt++;
                maxDpt = Math.max(maxDpt, currDpt);
            } else if (c == ')') {
                currDpt--;
            }
        }
        return maxDpt;
    }
}