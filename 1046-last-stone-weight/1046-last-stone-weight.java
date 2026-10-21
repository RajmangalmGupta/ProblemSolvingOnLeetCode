class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : stones){
            pq.offer(i);
        }
        for(int i=0;i<stones.length-1;i++){
            if(pq.size()>1){
                int x=pq.poll();
                int y=pq.poll();
                if(x==y) continue;
                if(x!=y){
                    pq.offer(Math.abs(x-y));
                }
            }
        }
        return (pq.size()>0)?pq.poll():0;
    }
}