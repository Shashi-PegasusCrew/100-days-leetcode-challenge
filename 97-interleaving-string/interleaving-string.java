class Solution {

    Boolean[][] dp = new Boolean[1001][1001];

    boolean fun(int i, int j, int k, String s1, String s2,
                String s3, Boolean[][] dp) {

        if (k >= s3.length())
            return i >= s1.length() && j >= s2.length();

        if (i >= s1.length()) {

            while (j < s2.length() && k < s3.length()) {

                if (s2.charAt(j) == s3.charAt(k)) {
                    j++;
                    k++;
                } 
                else {
                    return false;
                }
            }

            return j >= s2.length() && k >= s3.length();
        }

        if (j >= s2.length()) {

            while (i < s1.length() && k < s3.length()) {

                if (s1.charAt(i) == s3.charAt(k)) {
                    i++;
                    k++;
                } 
                else {
                    return false;
                }
            }

            return i >= s1.length() && k >= s3.length();
        }

        if (dp[i][j] != null)
            return dp[i][j];

        boolean ans = false;

        if (s1.charAt(i) == s3.charAt(k)) {

            boolean tmp = fun(i + 1, j, k + 1,
                             s1, s2, s3, dp);

            ans = ans || tmp;
        }

        if (s2.charAt(j) == s3.charAt(k)) {

            boolean tmp = fun(i, j + 1, k + 1,
                             s1, s2, s3, dp);

            ans = ans || tmp;
        }

        return dp[i][j] = ans;
    }

    public boolean isInterleave(String s1, String s2, String s3) {

        Boolean[][] dp = new Boolean[1001][1001];

        return fun(0, 0, 0, s1, s2, s3, dp);
    }
}