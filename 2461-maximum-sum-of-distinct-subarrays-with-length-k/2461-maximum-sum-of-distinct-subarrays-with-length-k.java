class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        int i=0;
        long max=0;
        long sum=0;
        for(int j=0;j<nums.length;j++){
            while(set.contains(nums[j])){
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }
            set.add(nums[j]);
            sum+=nums[j];
            if(j-i+1==k){
                max=Math.max(sum,max);
                set.remove(nums[i]);
                sum-=nums[i];
                i++;
            }
        }
        return max;
    }
}