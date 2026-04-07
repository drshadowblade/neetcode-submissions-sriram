class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(backtrack(board,i,j,0,word))
                    return true;
            }
        }
        return false;
    }
    public boolean backtrack(char[][] board,int row,int col,int index,String word)
    {
        if(index==word.length())
            return true;
        
        if(row<0 || col<0 || row>=board.length || col>=board[0].length || board[row][col]!=word.charAt(index))
            return false;

        char temp=board[row][col];
        board[row][col]='*';
        boolean found=backtrack(board,row+1,col,index+1,word) ||
                        backtrack(board,row-1,col,index+1,word) ||
                        backtrack(board,row,col+1,index+1,word) ||
                        backtrack(board,row,col-1,index+1,word);
        board[row][col]=temp;
        return found;
    }
}
