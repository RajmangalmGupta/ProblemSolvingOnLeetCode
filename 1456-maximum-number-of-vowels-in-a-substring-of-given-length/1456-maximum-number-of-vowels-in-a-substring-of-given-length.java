class Solution {
    public int maxVowels(String c, int k) {
        int count=0;
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<k;i++){
            if(c.charAt(i)=='a'||c.charAt(i)=='e'||c.charAt(i)=='i'||c.charAt(i)=='o'||c.charAt(i)=='u'){
                count++;
            }
        }
        int maxCount=count;
        for(int i=k;i<c.length();i++){
            if(c.charAt(i-k)=='a'||c.charAt(i-k)=='e'||c.charAt(i-k)=='i'||c.charAt(i-k)=='o'||c.charAt(i-k)=='u'){
                count--;
            }
            if(c.charAt(i)=='a'||c.charAt(i)=='e'||c.charAt(i)=='i'||c.charAt(i)=='o'||c.charAt(i)=='u'){
                count++;
            }
            maxCount=Math.max(count,maxCount);
            if(maxCount==k){
                return k;
            }
        }
        return maxCount;
    }
}