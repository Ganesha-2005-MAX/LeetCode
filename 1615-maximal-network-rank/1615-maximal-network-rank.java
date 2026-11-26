class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] d = new int[n];
        boolean[][] vis = new boolean[n][n];

        for(int[] r : roads){
            int u = r[0];
            int v = r[1];

            d[u]++;
            d[v]++;

            vis[u][v] = true;
            vis[v][u] = true;
        }

        int max = 0;
        for(int i =0;i<n;i++){
            for(int j = i+1;j<n;j++){
                int rank = d[i]+d[j];

                if(vis[i][j]) rank--;
                max = Math.max(max,rank);
            }
           
        }
        return max;

    }
}