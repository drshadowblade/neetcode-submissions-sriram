class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1)
            return Arrays.asList(0);
        int[] degree=new int[n];
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<edges.length;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }
        for(int i=0;i<n;i++)
        {
            if(degree[i]==1)
                q.offer(i);
        }
        int remaining=n;
        while(remaining>2)
        {
            int size=q.size();
            remaining-=size;
            for(int i=0;i<size;i++){
            int node=q.poll();
            for(int nei:graph.get(node))
            {
                degree[nei]--;
                if(degree[nei]==1)
                    q.offer(nei);
            }
            }
        }
        return new ArrayList<>(q);
    }
}