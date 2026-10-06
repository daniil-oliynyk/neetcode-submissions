class Solution {

    public static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}}; 

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int ROWS = heights.length;
        int COLS = heights[0].length;
        
        boolean[][] pacset = new boolean[ROWS][COLS];
        boolean[][] atlset = new boolean[ROWS][COLS];
         
        for(int r = 0; r<ROWS; r++){
            dfs(r,0,pacset,heights);
            dfs(r, COLS-1,atlset, heights);
        }
        for (int c = 0; c<COLS; c++) {
            dfs(0,c,pacset,heights);
            dfs(ROWS-1,c,atlset, heights);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int r = 0; r<ROWS;r++) {
            for (int c = 0; c<COLS;c++){
                if (pacset[r][c] && atlset[r][c]) {
                    res.add(Arrays.asList(r,c));
                }
            }
        }
        
        return res;
        
    }
    public void dfs(int r, int c, boolean[][] visited, int[][] heights) {
     
        int ROWS = heights.length;
        int COLS = heights[0].length;
        visited[r][c] = true;
        for (int[] dir: directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS && !visited[nr][nc] && heights[nr][nc] >= heights[r][c]){
                dfs(nr,nc,visited,heights);
            }
        }
    }
}
