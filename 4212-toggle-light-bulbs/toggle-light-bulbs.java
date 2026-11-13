class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        int[] count = new int[101];     
        for (int b : bulbs) {
            count[b]++;
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            if (count[i] % 2 != 0) {
                result.add(i);
            }
        }        
        return result;
    }
}