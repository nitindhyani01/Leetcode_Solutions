class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if ((m + n - 1) % 2 != 0) return false;
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') return false;
        Boolean[][][] memo = new Boolean[m][n][m + n];
        return dfs(grid, 0, 0, 0, memo);
    }
    
    private boolean dfs(char[][] grid, int r, int c, int balance, Boolean[][][] memo) {
        int m = grid.length;
        int n = grid[0].length;
        
        balance += (grid[r][c] == '(') ? 1 : -1;
        if (balance < 0) return false;
        if (balance > (m - 1 - r) + (n - 1 - c)) return false;
        
        if (r == m - 1 && c == n - 1) {
            return balance == 0;
        }
        if (memo[r][c][balance] != null) {
            return memo[r][c][balance];
        }
        
        
        boolean isValid = false;
        if (r + 1 < m) {
            isValid = isValid || dfs(grid, r + 1, c, balance, memo);
        }
        if (!isValid && c + 1 < n) {
            isValid = isValid || dfs(grid, r, c + 1, balance, memo);
        }
        
        return memo[r][c][balance] = isValid;
    }
}