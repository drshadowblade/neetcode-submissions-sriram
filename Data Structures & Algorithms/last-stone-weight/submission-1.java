class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q=new PriorityQueue<>(Collections.reverseOrder());

        for(int num:stones)
            q.offer(num);

        while(q.size()>1)
        {
            int x=q.poll();
            int y=q.poll();

            if(x!=y)
                q.offer(x-y);
        }
        return q.isEmpty() ? 0:q.peek();
    }
}
