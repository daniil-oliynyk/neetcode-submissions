class Solution {
    public int orangesRotting(int[][] grid) {

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int fresh = 0;
        
        if(ROWS == 1 && COLS == 1 && grid[0][0] == 0) {
            return 0;
        }

        for (int i = 0; i<ROWS; i++) {
            for (int j = 0; j<COLS; j++) {
                if(grid[i][j] == 1){
                    fresh++;
                }
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }
            }
        }
        
        // if(queue.size() == 0) {
        //     return -1;
        // }

        int minute = 0;
        while (fresh>0 && !queue.isEmpty()) {
            int qlen = queue.size();
            for (int i =0;i<qlen;i++){
                int[] temp = queue.poll();
                int r = temp[0];
                int c = temp[1];
                for (int[] dir: directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if(nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        queue.add(new int[]{nr,nc});
                        fresh--;
                    }
                }
            }
            minute+=1;
        }

        return fresh == 0 ? minute : -1;
    }
}
