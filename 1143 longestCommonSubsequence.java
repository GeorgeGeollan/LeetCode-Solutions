class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] letter1 = text1.toCharArray();
        char[] letter2 = text2.toCharArray();
        int m = text1.length(), n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                if(letter1[i - 1] == letter2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m][n];
    }
}
