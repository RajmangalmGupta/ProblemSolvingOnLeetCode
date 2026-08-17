class Solution {
    public long sq(long n){
        long sum=0;
        while(n>0){
            long dig = n%10;
            sum += dig*dig;
            n = n/10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        long slow = sq(n);
        long fast = sq(sq(n));
        while(fast!=slow){
            slow = sq(slow);
            fast = sq(sq(fast));
        }
        return slow ==1;
    }
}