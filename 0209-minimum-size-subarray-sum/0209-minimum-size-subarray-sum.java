class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int l=0;
        int h=0;
        int ans = Integer.MAX_VALUE;
        int sum=0;
        while(h<n){
            sum = sum + nums[h];
            while(sum >= target){
                ans=Math.min(ans , h-l+1);
                sum = sum - nums[l];
                l++;
            }
            h++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}