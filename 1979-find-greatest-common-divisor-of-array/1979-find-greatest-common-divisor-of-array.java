class Solution {
    public int findGCD(int[] nums) {
        int n = nums.length;
        int m1 = nums[0];
        int mn = nums[0];
        for(int i=0;i<n;i++){
            if(nums[i]>mn){
                mn = nums[i];
            }
            if(nums[i]<m1){
                m1 = nums[i];
            }
        }
        while(mn!=0){
            int x = mn;
            mn = m1 % mn;
            m1 = x;
        }
        return m1;
    }
}