/*
Problem : 
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X

*/

/*
Analysis ::
Time Complexity :: O(mn)
Space Complexity :: O(mn)
*/

class Solution {
    public void solve(char[][] board) {
        if(board.length == 0)
            return;
        
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++){
            if(board[i][0] == 'O')
                updateBoard(board, i, 0);
            if(board[i][n-1] == 'O')
                updateBoard(board, i, n-1);
        }
        for(int j=0; j<n; j++){
            if(board[0][j] == 'O')
                updateBoard(board, 0, j);
            if(board[m-1][j] == 'O')
                updateBoard(board, m-1, j);
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }
    
    private void updateBoard(char[][] board, int row, int col){
        if(row<0 || col<0 || row>=board.length || col>=board[0].length)
            return;
        if(board[row][col] == 'X' || board[row][col] == '*')
            return;
        
        if(board[row][col] == 'O')
            board[row][col] = '*';
            
        updateBoard(board, row-1, col);
        updateBoard(board, row+1, col);
        updateBoard(board, row, col-1);
        updateBoard(board, row, col+1);
    }
}