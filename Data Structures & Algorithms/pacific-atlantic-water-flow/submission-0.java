class Solution {
    int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        Queue<int[]> pq=new LinkedList<>();
        Queue<int[]> aq=new LinkedList<>();

        boolean[][] pacific=new boolean[m][n];
        boolean[][] atlantic=new boolean[m][n];

        for(int i=0;i<m;i++)
        {
            pq.offer(new int[]{i,0});
            pacific[i][0]=true;

            aq.offer(new int[]{i,n-1});
            atlantic[i][n-1]=true;
        }
        for(int i=0;i<n;i++)
        {
            pq.offer(new int[]{0,i});
            pacific[0][i]=true;

            aq.offer(new int[]{m-1,i});
            atlantic[m-1][i]=true;
        }
        bfs(pq,pacific,heights);
        bfs(aq,atlantic,heights);
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(pacific[i][j] && atlantic[i][j])
                    result.add(Arrays.asList(i,j));
            }
        }
        return result;
    }
    private void bfs(Queue<int[]> queue,boolean[][] ocean,int[][] heights)
    {
        while(!queue.isEmpty())
        {
            int[] curr=queue.poll();
            int row=curr[0];
            int col=curr[1];
            for(int[] dir:dirs)
            {
                int r=curr[0]+dir[0];
                int c=curr[1]+dir[1];
                if(r<0 || c<0 || r>=ocean.length || c>=ocean[0].length) continue;
                if(ocean[r][c]) continue;
                if(heights[r][c]>=heights[row][col])
                {
                    ocean[r][c]=true;
                    queue.offer(new int[]{r,c});
                }
            }
        }
    }
}
