class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        List<int[]> list=new ArrayList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0)
                {
                    list.add(new int[]{i,j});
                }
            }
        }
        for(int[] arr:list)
        {
            set(matrix,arr[0],arr[1]);
        }
    }
    public void set(int[][] matrix,int r,int c)
    {
        for(int i=0;i<matrix.length;i++)
            matrix[i][c]=0;
        for(int i=0;i<matrix[0].length;i++)
            matrix[r][i]=0;
    }
}
