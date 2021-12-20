class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        for(int i = 0; i < n; i++)
            dp[0][i] = matrix[0][i];

        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(j < 1)
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) +  matrix[i][j];

                else if(j >= n -1)
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) +  matrix[i][j];

                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i - 1][j + 1]) + matrix[i][j];
            }
        }

        for(int i = 0; i < n; i++) {
            if(min > dp[m - 1][i])
                min = dp[m - 1][i];
        }

        return min;
    }
}
