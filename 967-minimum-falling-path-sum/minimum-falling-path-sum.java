class Solution {
    int fun(int i,int j,int[][] matrix,int[][] dp){
        int n=matrix.length;
        int m=matrix[0].length;

        if(i<0 ||i>=n || j<0 ||j>=m) return (int)1e9;

        if(i==n-1) return matrix[i][j];

         if(dp[i][j]!=(int)-1e9){
        return dp[i][j];
    }

        int left=matrix[i][j]+fun(i+1,j-1,matrix,dp);
        int right=matrix[i][j]+fun(i+1,j+1,matrix,dp);
        int down=matrix[i][j]+fun(i+1,j,matrix,dp);

        return dp[i][j] =Math.min(left,Math.min(right,down));
    }
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int ans= (int)1e9;

        int [][]dp=new int[matrix.length][matrix[0].length];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],(int)-1e9);
        }

        for(int i=0;i<n;i++){
            ans=Math.min(ans,fun(0,i,matrix,dp));
        }
        return ans;

    }
}