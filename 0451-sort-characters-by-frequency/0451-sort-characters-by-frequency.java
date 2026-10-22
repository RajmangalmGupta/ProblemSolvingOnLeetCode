import java.util.Collections;
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(
                map.get(b),
                map.get(a)
            )
        );
        pq.addAll(map.keySet());
        int n = s.length();
        StringBuilder str = new StringBuilder();
        while(!pq.isEmpty()){
            char ch = pq.poll();
            for(int i=0;i<map.get(ch);i++){
                str.append(ch);
            }
        }
        return str.toString();
    }
}