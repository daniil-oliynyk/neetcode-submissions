class Solution {

    public static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public void solve(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;

        for(int r = 0;r<ROWS;r++) {
            if(board[r][0] == 'O'){
                dfs(r,0,board);
            }
            if(board[r][COLS-1] == 'O'){
                dfs(r,COLS-1,board);
            }
        }
        for(int c = 0;c<COLS;c++) {
            if(board[0][c] == 'O'){
                dfs(0,c,board);
            }            
            if(board[ROWS-1][c] == 'O'){
                dfs(ROWS-1,c, board);
            }        
        }


        for(int r = 0;r<ROWS;r++) {
            for (int c = 0;c<COLS;c++){
                if(board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == '#'){
                    board[r][c] = 'O';
                }
            }
        }
    }
    public void dfs(int r, int c, char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;
        if ( r >= 0 && r < ROWS && c >= 0 && c < COLS && board[r][c] == 'O') {
            board[r][c] = '#';
            for(int[] dir: directions) {
                int nr = r+dir[0];
                int nc = c+dir[1];
                dfs(nr,nc,board);
            }    
        }
        
    }
}
