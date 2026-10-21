import java.util.PriorityQueue;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(freq.get(a), freq.get(b))
        );
        for(int i : freq.keySet()){
            minHeap.offer(i);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        int[] elements = new int[k];
        for(int i=k-1;i>=0;i--){
            elements[i] = minHeap.poll(); 
        }
        return elements;
    }
}