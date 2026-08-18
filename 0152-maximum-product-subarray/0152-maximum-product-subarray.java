class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int best = nums[0];
        int worst = nums[0];
        for(int i=1;i<nums.length;i++){
            int a = nums[i]*best;
            int b = nums[i]*worst;
            int c = nums[i];
            best = Math.max(a,Math.max(b,c));
            worst = Math.min(a,Math.min(b,c));
            ans = Math.max(best,ans);
        }
        return ans;
    }
}