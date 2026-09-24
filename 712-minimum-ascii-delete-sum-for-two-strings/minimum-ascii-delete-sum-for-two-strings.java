class Solution {
    int dp[][];

    public int fun(String s, String t, int i, int j) {
        int n = s.length();
        int m = t.length();
        if (i == n) {
            int sum = 0;
            while (j < m) {
                sum += t.charAt(j);
                j++;
            }
            return sum;
        }
        if (j == m) {
            int sum = 0;

            while (i < n) {
                sum += s.charAt(i);
                i++;
            }
            return sum;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = fun(s, t, i + 1, j + 1);
        }
        int c1 = s.charAt(i) + fun(s, t, i + 1, j);
        int c2 = t.charAt(j) + fun(s, t, i, j + 1);

        return dp[i][j] = Math.min(c1, c2);
    }

    public int minimumDeleteSum(String s, String t) {
        dp = new int[1001][1001];

        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return fun(s, t, 0, 0);
    }

}