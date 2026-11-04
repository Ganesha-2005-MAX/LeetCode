class Solution {
    public int slove(int i, int j, int arr[], int [][] dp){
        if(j-i==1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min_cost = Integer.MAX_VALUE;
        for(int k = i+1;k<j;k++){
            int res = slove(i,k,arr,dp)+slove(k,j,arr,dp)+ arr[j]-arr[i];
            min_cost = Math.min(res,min_cost);
        }
        return dp[i][j] = min_cost;
    }
    public int minCost(int n, int[] cuts) { 
        int m = cuts.length;
        Arrays.sort(cuts);
        int[] arr = new int[m+2];
        int[][] dp = new int[m+2][m+2];
        arr[0] = 0;
        arr[m+1] = n;
        for(int i=0;i<m;i++) arr[i+1] = cuts[i];
        for(int[] row : dp) Arrays.fill(row,-1);
        return slove(0,m+1,arr,dp);
    }
}