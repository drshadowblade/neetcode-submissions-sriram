class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((x,y)->x[1]-y[1]);
        boolean[] visited=new boolean[n];
        int totalCost=0;
        int usedNodes=0;
        pq.offer(new int[]{0,0});
        while(usedNodes<n)
        {
            int[] p=pq.poll();
            int node=p[0];
            int edge=p[1];

            if(visited[node])
                continue;
            
            visited[node]=true;
            usedNodes++;
            totalCost+=edge;
            for(int next=0;next<n;next++)
            {
                if(!visited[next]){
                    int dist=Math.abs(points[node][0]-points[next][0])+
                                Math.abs(points[node][1]-points[next][1]);
                    pq.offer(new int[]{next,dist});
                }
            }
        }
        return totalCost;
    }
}
