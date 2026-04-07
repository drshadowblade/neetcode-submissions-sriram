class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited=new boolean[n];
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());
        for(int[] edge:edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                dfs(i,graph,visited);
                count++;
            }
        }
        return count;
    }
    private void dfs(int i,List<List<Integer>> graph,boolean[] visited)
    {
        visited[i]=true;
        for(int nei:graph.get(i))
        {
            if(!visited[nei])
                dfs(nei,graph,visited);
        }
    }
}
