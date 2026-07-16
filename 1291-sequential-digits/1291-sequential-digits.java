class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        String digits = "123456789";
        for(int i=1;i<=9;i++){
            for(int j=0;j<10-i;j++){
                int num = Integer.parseInt(digits.substring(j,i+j));
                if(num>=low && num<=high){
                    ans.add(num);
                }
            }
        }
        return ans;
    }
}