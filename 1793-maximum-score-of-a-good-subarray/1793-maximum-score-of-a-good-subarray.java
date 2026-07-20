class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int[] pse = new int[n];
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            if(st.isEmpty()) pse[i] = -1;
            else pse[i] = st.peek();
            st.push(i);
        }

        st.clear();

        for(int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            if(st.isEmpty()) nse[i] = n;
            else nse[i] = st.peek();
            st.push(i);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(k<nse[i] && k>pse[i]){
                int score = nums[i]*(nse[i]-pse[i]-1);
                ans = Math.max(score,ans);
            }
        }
        return ans;
    }
}