class Solution {
    public void islandsAndTreasure(int[][] grid) {
        
        int INF = 2147483647; 
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;

        for(int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++){
                if (grid[r][c] == 0) {
                    queue.add(new int[]{r,c});
                }
            }
        }        

        if(queue.size() == 0) {
            return;
        }

        while(!queue.isEmpty()) {

            int[] temp = queue.poll();
            int r = temp[0];
            int c = temp[1];
            
            for(int[] dir: directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == INF) {
                    queue.add(new int[]{nr,nc});
                    grid[nr][nc] = grid[r][c]+1;
                }     
            }
        }
    }
}
