class Solution {
    private static final int INF = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        Queue<Pair<Integer,Integer>> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==0)
                    q.add(new Pair<>(i,j));
            }
        }
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty())
        {
            Pair p=q.poll();
            int r=(Integer)p.getKey();
            int c=(Integer)p.getValue();
            for(int[] d:dir)
            {
                int nr=r+d[0];
                int nc=c+d[1];

                if(nr<0 || nc<0 || nr>=grid.length || nc>=grid[0].length)
                    continue;
                if(grid[nr][nc]!=INF)
                    continue;
                grid[nr][nc]=grid[r][c]+1;
                q.add(new Pair<>(nr,nc));
            }
        }
    }
}
