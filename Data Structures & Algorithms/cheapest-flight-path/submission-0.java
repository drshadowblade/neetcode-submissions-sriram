class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] flight:flights)
        {
            int sour=flight[0];
            int dest=flight[1];
            int cost=flight[2];
            adj.get(sour).add(new int[]{dest,cost});
        }
        int[] bestStops=new int[n];
        for(int i=0;i<n;i++)
        {
            bestStops[i]=Integer.MAX_VALUE;
        }
        pq.offer(new int[]{src,0,0});
        while(!pq.isEmpty())
        {
            int[] arr=pq.poll();
            int node=arr[0];
            int cost=arr[1];
            int stops=arr[2];
            if(stops>k+1)
                continue;
            if(node==dst)
                return cost;
            if(stops>bestStops[node])
                continue;
            bestStops[node]=stops;
            for(int j=0;j<adj.get(node).size();j++)
            {
                int[] ar=adj.get(node).get(j);
                int edge=ar[0];
                int weight=ar[1];
                pq.offer(new int[]{edge,cost+weight,stops+1});
            } 
        }
        return -1;
    }
}
