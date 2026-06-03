class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++)
        {
            int src=times[i][0];
            int dest=times[i][1];
            int weight=times[i][2];
            adj.get(src).add(new int[]{dest,weight});
            
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((x,y)->x[1]-y[1]);
        int[] dist=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            dist[i]=(int)(1e9);
        }
        dist[k]=0;
        pq.add(new int[]{k,0});
        while(!pq.isEmpty())
        {
            int[] p=pq.poll();
            int node=p[0];
            int dis=p[1];
            if(dis>dist[node]) continue;
            for(int i=0;i<adj.get(node).size();i++)
            {
                int edge=adj.get(node).get(i)[0];
                int d=adj.get(node).get(i)[1];
                if(dis+d<dist[edge]){
                    dist[edge]=dis+d;
                    pq.add(new int[]{edge,dist[edge]});
                }
            }
        }
        int max=-1;
        for(int i=1;i<=n;i++)
        {
            if(dist[i]==(int)(1e9))
                return -1;
            if(dist[i]>max)
                max=dist[i];
        }
        return max;
    }
}
