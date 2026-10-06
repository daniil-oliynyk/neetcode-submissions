class Solution {
    HashSet<Integer> visited = new HashSet<>();
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    public int countComponents(int n, int[][] edges) {
        if(n == 0) {
            return 0;
        }
        if(edges.length == 0) {
            return n;
        }

        int ROWS = edges.length;
        int COLS = edges[0].length;


        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int result = 0;
        for(int node = 0; node<n;node++) {
            if(!visited.contains(node)) {
                dfs(node);
                result++;
            }
        }
        return result;
    }

    public void dfs(int node) {
        visited.add(node);
        ArrayList<Integer> neighbours = adj.get(node);
        for (int n : neighbours) {
            if(!visited.contains(n)){
                dfs(n);
            }
        }
    }
}
