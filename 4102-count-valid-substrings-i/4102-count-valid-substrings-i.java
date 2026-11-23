class Solution {
    public long countValidSubstrings(String s) {
        int n = s.length();
        long c = 0;
        long l =0;
        for(int r = 0;r<n;r++){
            if(r>=2 && s.charAt(r-2)=='a' && s.charAt(r-1)=='b' && s.charAt(r)=='c'){
                l=Math.max(l,r-1);
                
            }
            c+=(r-l+1);
        }
        return c;
    }
}