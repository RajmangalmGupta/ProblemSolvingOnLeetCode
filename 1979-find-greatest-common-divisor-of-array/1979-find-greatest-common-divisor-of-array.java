class Solution {
    public int findGCD(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int m1 = nums[0];
        int mn = nums[n-1];
        while(mn!=0){
            int x = mn;
            mn = m1 % mn;
            m1 = x;
        }
        return m1;
    }
}