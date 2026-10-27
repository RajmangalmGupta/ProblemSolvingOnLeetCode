class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int Sum=0;
        for(int i=0;i<k;i++){
            Sum+=nums[i];
        }
        int maxSum=Sum;
        for(int i=k;i<nums.length;i++){
            
            Sum-=nums[i-k];
            Sum+=nums[i];
            maxSum=Math.max(Sum,maxSum);
        }
        return (double)maxSum/k;
    }
}