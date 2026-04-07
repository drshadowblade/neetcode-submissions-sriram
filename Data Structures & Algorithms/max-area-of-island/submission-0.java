class Solution {
    int maxArea=0;
    private int dfs(int[][] grid,int i,int j)
    {
        grid[i][j]=0;
        int area=1;
        if(i>0 && grid[i-1][j]==1) area+=dfs(grid,i-1,j);
        if(i<grid.length-1 && grid[i+1][j]==1) area+=dfs(grid,i+1,j);
        if(j>0 && grid[i][j-1]==1) area+=dfs(grid,i,j-1);
        if(j<grid[0].length-1 && grid[i][j+1]==1) area+=dfs(grid,i,j+1);
        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    int area=dfs(grid,i,j);
                    maxArea=Math.max(area,maxArea);
                }
            }
        }
        return maxArea;
    }
}
