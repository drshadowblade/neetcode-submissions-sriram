class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int l=0;
        int r=n-1;
        while(l<r)
        {
            int[] temp=matrix[l];
            matrix[l]=matrix[r];
            matrix[r]=temp;
            l++;
            r--;
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }
}
