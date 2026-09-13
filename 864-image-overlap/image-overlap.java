class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int maxOverlap = 0;
        for (int rShift = -(n - 1); rShift < n; rShift++) {
            for (int cShift = -(n - 1); cShift < n; cShift++) {
                maxOverlap = Math.max(maxOverlap, countOverlap(img1, img2, rShift, cShift));
            }
        }
        return maxOverlap;
    }

    private int countOverlap(int[][] img1, int[][] img2, int rShift, int cShift) {
        int n = img1.length;
        int count = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int r2 = r + rShift;
                int c2 = c + cShift;
                if (r2 >= 0 && r2 < n && c2 >= 0 && c2 < n) {
                    if (img1[r][c] == 1 && img2[r2][c2] == 1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}