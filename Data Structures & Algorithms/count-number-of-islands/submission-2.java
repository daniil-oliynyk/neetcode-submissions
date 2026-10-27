class Solution {
    

    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public int numIslands(char[][] grid) {
        if(grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    bfs(r,c,grid);
                    islands += 1;
                }
            }
        }
        return islands;

    }
    public void bfs(int r, int c, char[][] grid) {
        Deque<int[]> q = new ArrayDeque<>();
        grid[r][c] = '0';

        q.offer(new int[]{r,c});

        while (!q.isEmpty()) {
            int[] node = q.pollLast();
            int row = node[0];
            int col = node[1];

            for (int[] dir : directions) {
                int nr = row + dir[0];
                int nc = col + dir[1];
                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1') {
                    q.add(new int[]{nr,nc});
                    grid[nr][nc] = '0';
                }
            }
        }
    }
}
