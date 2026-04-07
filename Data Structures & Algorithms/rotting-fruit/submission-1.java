class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        int m = grid.length;
        int n = grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2)
                    q.offer(new int[]{i,j});
                else if(grid[i][j]==1)
                    fresh++;
            }
        }

        if(fresh==0) return 0;

        int minutes = -1;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){

            int size = q.size();
            minutes++;

            for(int i=0;i<size;i++){

                int[] curr = q.poll();

                for(int[] d : dirs){

                    int r = curr[0] + d[0];
                    int c = curr[1] + d[1];

                    if(r>=0 && c>=0 && r<m && c<n && grid[r][c]==1){

                        grid[r][c] = 2;
                        fresh--;

                        q.offer(new int[]{r,c});
                    }
                }
            }
        }

        return fresh==0 ? minutes : -1;
    }
}