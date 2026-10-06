class Solution {

    public HashSet<Integer> visited = new HashSet<>();
    public ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    
    public boolean validTree(int n, int[][] edges) {
        if (n == 0) {
            return true;
        }

        for(int i = 0; i<n;i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }



        return dfs(0,-1) && visited.size() == n;


    }
    public boolean dfs(int visiting,int prev) {
        if(visited.contains(visiting)){
            return false;
        }
        visited.add(visiting);
        for(int n : adj.get(visiting)){
            if (n == prev) {
                continue;
            }
            if(!dfs(n, visiting)){
                return false;
            }
        }
        return true;
    }
}
