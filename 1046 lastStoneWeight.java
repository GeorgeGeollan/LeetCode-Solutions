class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        for(int i = 0; i < stones.length; i++) {
            pq.add(stones[i]);
        }
        
        while(pq.size() > 1) {
            int x = pq.peek();
            pq.remove();
            int y = pq.peek();
            pq.remove();
            
            if(x != y)
                pq.add(x - y);
        }
        
        return pq.size() == 0 ? 0 : pq.peek();
    }
}
