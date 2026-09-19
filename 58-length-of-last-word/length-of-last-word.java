class Solution {
    public int lengthOfLastWord(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z0-9\\s]", "");
        String[] words = cleaned.trim().split("\\s+");
        int n = words.length-1;
        String last = words[n];
        int count = 0;
        for(int i = 0; i < last.length(); i++){
            count++;
        }
        return count;
    }
}