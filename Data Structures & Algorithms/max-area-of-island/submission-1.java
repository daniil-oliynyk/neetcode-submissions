class Solution {

    int maxArea = 0;

    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public int maxAreaOfIsland(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    bfs(r,c,grid);
                }
            }
        }
        return maxArea;

    }
    public void bfs(int r, int c, int[][]grid){
        Queue<int[]> q = new LinkedList<>();
        int currMax = 0;
        grid[r][c] = 0;

        q.add(new int[] {r,c});

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];

            currMax++;

            for (int[] dir: directions) {
                int nr = row + dir[0];
                int nc = col + dir[1];
                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc]==1) {
                    q.add(new int[]{nr,nc});
                    grid[nr][nc] = 0;
                }
            }
        }
        maxArea = Math.max(maxArea,currMax);
    }
}
