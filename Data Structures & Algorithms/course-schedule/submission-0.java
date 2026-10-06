class Solution {
    
    public HashMap<Integer, ArrayList<Integer>> preMap = new HashMap<>();
    public Set<Integer> visitSet = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }
        
        for (int[] prq: prerequisites) {
            int key = prq[0];
            int prereq = prq[1];
            preMap.get(key).add(prereq);
        }

        for(int c = 0; c<numCourses; c++){
            if (!dfs(c)){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int course) {
        if (visitSet.contains(course)) {
            return false;
        }
        if (preMap.get(course).size() == 0) {
            return true;
        }
        visitSet.add(course);
        ArrayList<Integer> prereqs = preMap.get(course);
        for(int prq: prereqs) {
            if (!dfs(prq)) {
                return false;
            }
        }
        visitSet.remove(course);
        // preMap.get(course)
        return true;
    }
}
