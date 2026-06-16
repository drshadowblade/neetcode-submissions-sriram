class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        boolean[] zeroR=new boolean[m];
        boolean[] zeroC=new boolean[n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0)
                {
                    zeroR[i]=true;
                    zeroC[j]=true;
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(zeroR[i]==true || zeroC[j]==true)
                    matrix[i][j]=0;
            }
        }
    }
}
