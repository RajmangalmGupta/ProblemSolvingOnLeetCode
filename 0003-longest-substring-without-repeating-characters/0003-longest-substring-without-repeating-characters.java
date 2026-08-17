class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int size=0;
        int left=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i); 
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while(map.get(ch)>1){
                char c = s.charAt(left);
                map.put(c,map.get(c)-1);
                left++;
            }
            size = Math.max(size,i-left+1);
        }
        return size;
    }
}