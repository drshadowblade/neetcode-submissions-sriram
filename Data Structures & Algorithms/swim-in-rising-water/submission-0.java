class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int[][] matrix=new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(matrix[i],Integer.MAX_VALUE);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.offer(new int[]{0,0,0});
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        List<Integer> path=new ArrayList<>();
        int max=0;
        while(!pq.isEmpty())
        {
            int[] arr=pq.poll();
            int r=arr[0];
            int c=arr[1];
            if(grid[r][c]>max)
                max=grid[r][c];
            if(r==n-1 && c==n-1)
                break;
            int cost=arr[2];
            for(int i=0;i<4;i++)
            {
                int nr=r+dir[i][0];
                int nc=c+dir[i][1];
                if(nr<n && nc<n && nr>=0 && nc>=0)
                {
                    if(grid[nr][nc]<matrix[nr][nc])
                    {
                        matrix[nr][nc]=grid[nr][nc];
                        pq.offer(new int[]{nr,nc,grid[nr][nc]});
                    }
                }
            }

        }
        return max;
    }
}
