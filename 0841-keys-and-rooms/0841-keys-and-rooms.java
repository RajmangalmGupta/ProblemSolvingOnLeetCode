class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size();
        boolean[] visit = new boolean[size];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);           
        visit[0] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int neigbhour : rooms.get(node)){
                if(!visit[neigbhour]){
                    visit[neigbhour]=true;
                    q.offer(neigbhour);
                }
            }
        }
        for(int i=0;i<visit.length;i++){
            if(!visit[i]) return false;
        }
        return true;
    }
}