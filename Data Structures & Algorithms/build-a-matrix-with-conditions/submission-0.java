class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> rowOrder=toposort(k,rowConditions);
        List<Integer> colOrder=toposort(k,colConditions);
        int[][] matrix=new int[k][k];
        if(rowOrder.size()!=k || colOrder.size()!=k)
            return new int[][]{};
        HashMap<Integer,Integer> rowPos=new HashMap<>();
        HashMap<Integer,Integer> colPos=new HashMap<>();
        for(int i=0;i<k;i++)
        {
            rowPos.put(rowOrder.get(i),i);
            colPos.put(colOrder.get(i),i);
        }
        for(int i=1;i<=k;i++)
        {
            matrix[rowPos.get(i)][colPos.get(i)]=i;
        }
        return matrix;
    }
    public List<Integer> toposort(int k,int[][] conditions)
    {
        List<List<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[k+1];
        for(int i=0;i<=k;i++)
            adj.add(new ArrayList<>());
        for(int[] con:conditions)
        {
            adj.get(con[0]).add(con[1]);
            indegree[con[1]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=k;i++)
        {
            if(indegree[i]==0)
                q.add(i);
        }
        List<Integer> order=new ArrayList<>();
        while(!q.isEmpty())
        {
            int node=q.poll();
            order.add(node);
            for(int num:adj.get(node))
            {
                indegree[num]--;
                if(indegree[num]==0)
                    q.add(num);
            }
        }
        return order;
    }
}