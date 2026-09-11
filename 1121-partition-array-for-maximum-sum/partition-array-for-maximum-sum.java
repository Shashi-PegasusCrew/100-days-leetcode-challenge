class Solution {
    int [][]dp=new int [500][500];
    int fun(int i, int prev, int m, int[] arr, int k) {
        if (i >= arr.length)
            return 0;
        int length = i - prev + 1;
        if(dp[i][prev]!=-1) return dp[i][prev];
        m = Math.max(arr[i], m);
        int ans = 0;
        if (length == k) {
            int p = m * length + fun(i + 1, i + 1, 0, arr, k);
            ans = Math.max(ans, p);
        } else {
            int p = m * length + fun(i + 1, i + 1, 0, arr, k);
            int np = fun(i + 1, prev, m, arr, k);
            ans = Math.max(ans, p);
            ans = Math.max(ans, np);
        }
        return dp[i][prev]=ans;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        for(int[] f: dp){
            Arrays.fill(f,-1);
        }
        return fun(0, 0, 0, arr, k);
    }
}