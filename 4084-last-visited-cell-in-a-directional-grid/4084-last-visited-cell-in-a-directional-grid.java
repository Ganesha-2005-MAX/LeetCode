class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] v = new boolean[n][m];
        int r = 0;
        int c = 0;
        v[r][c] = true;
        while(true){
            char cu = grid[r][c];
            int nextr = r;
            int nextc = c;
            if(cu=='L'){
                nextc--;
            }else if(cu=='R'){
                nextc++;
            }else if(cu=='U'){
                nextr--;
            }else if(cu=='D'){
                nextr++;
            }
            if(nextr <0 || nextr>=n || nextc<0 || nextc>=m ||v[nextr][nextc]){
                break;
            }
            r=nextr;
            c=nextc;
            v[r][c] =true;
        }
        return new int[]{r,c};
        
    }
}