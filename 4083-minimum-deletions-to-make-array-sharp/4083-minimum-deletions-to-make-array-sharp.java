class Solution {
    public int minDeletions(int[] nums) {
        int n = nums.length;
        int k =0;
        for(int i =0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                k++;
            }
        }
        return k;
    }
}