class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int total = nums[i]+nums[j]+nums[k];
                if(Math.abs(target-total)<Math.abs(target-result)){
                    result = total;
                }
                if (total == target) return target;
                else if (total < target) j++;
                else k--;
            }
        }
        return result;
    }
}