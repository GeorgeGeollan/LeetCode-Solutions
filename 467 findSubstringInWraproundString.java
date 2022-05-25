class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int k = 0;

        for(int i = 0; i < p.length(); i++) {
            if(i > 0 && (p.charAt(i) - p.charAt(i - 1) + 26) % 26 == 1)
                k++;

            else
                k = 1;

            dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], k);
        }

        int sum = 0;
        for(int i = 0; i < 26; i++)
            sum += dp[i];

        return sum;
    }
}
