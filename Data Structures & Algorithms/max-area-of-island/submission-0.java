class Solution {
    
    public static int[][] directions = {{1,0},{-1,0},{0,1} ,{0,-1}};

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c]==1) {
                    maxArea = Math.max(maxArea, bfs(grid, r , c));
                }
            }
        }    

        return maxArea;

    }

    public int bfs(int[][] grid, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        grid[r][c] = 0;
        queue.add(new int[]{r,c});
        int maxCurrArea = 1;

        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int row = temp[0];
            int col = temp[1];

            for(int[] dir : directions) {
                int nr = row + dir[0];
                int nc = col + dir[1];

                if(nr>=0 &&  nc >= 0 && nr<grid.length && nc < grid[0].length && grid[nr][nc] == 1) {
                    queue.add(new int[]{nr,nc});
                    grid[nr][nc] = 0;
                    maxCurrArea++;

                }
            }
        }
        return maxCurrArea;
    }
}
