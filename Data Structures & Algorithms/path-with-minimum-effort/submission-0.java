class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int[][] dist=new int[n][m];
        for(int[] row:dist)
            Arrays.fill(row,Integer.MAX_VALUE);
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[0]-b[0]);
        q.offer(new int[]{0,0,0});
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty())
        {
            int[] arr=q.poll();
            int eff=arr[0];
            int r=arr[1];
            int c=arr[2];
            if(r==n-1 && c==m-1)
                return eff;
            for(int i=0;i<4;i++)
            {
                int nr=r+dir[i][0];
                int nc=c+dir[i][1];
                if(nr>=0 && nc>=0 && nr<n && nc<m)
                {
                    int effort=Math.max(eff,Math.abs(heights[nr][nc]-heights[r][c]));
                    if(effort<dist[nr][nc])
                    {
                        dist[nr][nc]=effort;
                        q.offer(new int[]{effort,nr,nc});
                    }
                }
            }
        }
        return 0;
    }
}