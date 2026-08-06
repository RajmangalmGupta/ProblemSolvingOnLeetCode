class Solution {
    public int smallestNumber(int n, int t) {
        
        for(int i=n; ;i++){
            int prod=1;
            int x=i;
            while(x!=0){
                int a = x%10;
                prod*=a;
                x=x/10;
            }
            if(prod%t==0){
                return i;
            }
        }
        
    }
}