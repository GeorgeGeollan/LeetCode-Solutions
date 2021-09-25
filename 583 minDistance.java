class Solution {
    public int minDistance(String word1, String word2) {
       char[] letter1 = word1.toCharArray();
       char[] letter2 = word2.toCharArray();
       int m = word1.length(), n = word2.length();
       int[][] dp = new int[m + 1][n + 1];

       for(int i = 0; i <= m; i++)
           dp[i][0] = i;

        for(int j = 0; j <= n; j++)
           dp[0][j] = j;

        for(int i = 1; i <= m; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                dp[i][j] = Math.min(dp[i -1][j] + 1, dp[i][j - 1] + 1);

                if(letter1[i - 1] == letter2[j - 1])
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
            }
        }

        return dp[m][n];
        
    }
}
