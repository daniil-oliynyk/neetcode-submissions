class Solution {

    public static int[][] directions = {{1,0}, {-1,0},
                                        {0,1}, {0,-1}};
    public int numIslands(char[][] grid) {
        if(grid == null) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        for(int r = 0; r < rows; r++) {
            for (int c = 0; c< cols; c++) {
                if (grid[r][c] == '1') {
                    bfs(grid, r, c);
                    islands += 1;
                }
            }
        }

        return islands;
    }

    public void bfs(char[][] grid, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        grid[r][c] = '0';
        queue.add(new int[]{r,c});

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];

            for(int[] dir : directions) {
                int nr = row + dir[0];
                int nc = col + dir[1];
                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1' ) {
                    queue.add(new int[]{nr,nc});
                    grid[nr][nc] = '0';
                }
            }
        }
    }
}
