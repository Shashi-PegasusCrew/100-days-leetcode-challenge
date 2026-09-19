class Solution {
    private int[][][] dp;
    
     int fun(int i, int[] nums, int p, int k) {
        if (i >= nums.length) {
            return 0;
        }
        if (dp[i][p + 1][k] != -1) {
            return dp[i][p + 1][k];
        }

        int m = 0;

        if (p == -1 || nums[i] == nums[p]) {
            int a = 1 + fun(i + 1, nums, i, k);
            m = Math.max(m, a);
        } 
        else if (k > 0) {
            int b = 1 + fun(i + 1, nums, i, k - 1);
            m = Math.max(m, b);
        }
        int c = fun(i + 1, nums, p, k);
        m = Math.max(m, c);

        return dp[i][p + 1][k] = m;
    }
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        dp = new int[n + 1][n + 2][k + 1];
        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }

        return fun(0, nums, -1, k);
    }

    
}
