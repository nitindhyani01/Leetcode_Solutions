class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        if (k == 1)
            return n;

        int[][] t = new int[n + 1][n + 1];
        
        for (int i = n - 1; i >= 0; --i) {
            for (int j = n - 1; j >= i; --j) {

                if (isPalindrome(s, i, j)) {
                    int growWindow = t[i][j + 1];
                    int takeIt = 1 + (j + k <= n ? t[j + 1][j + k] : 0);
                    int slideWindow = t[i + 1][j + 1];

                    t[i][j] = Math.max(growWindow, Math.max(takeIt, slideWindow));
                }

                int slideWindow = t[i + 1][j + 1];
                int growWindow = t[i][j + 1];
                t[i][j] = Math.max(t[i][j], Math.max(slideWindow, growWindow));
            }
        }

        return t[0][k - 1];
    }

    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
}