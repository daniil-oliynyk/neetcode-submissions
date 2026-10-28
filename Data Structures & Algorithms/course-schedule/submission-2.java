class Solution {
    
    HashMap<Integer,ArrayList<Integer>> preMap = new HashMap<>();
    HashSet<Integer> visiting = new HashSet<>();    
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0; i<numCourses;i++) {
            preMap.put(i,new ArrayList<>());
        }
        for (int[] prereq: prerequisites) {
            ArrayList<Integer> prereqs = preMap.get(prereq[0]);
            prereqs.add(prereq[1]);
            preMap.put(prereq[0],prereqs);
        }
    
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int course) {
        if (visiting.contains(course)){
            return false;
        }
        if(preMap.get(course).isEmpty()) {
            return true;
        }
        visiting.add(course);
        ArrayList<Integer> prereqs = preMap.get(course);
        for (int prereq: prereqs) {
            if (!dfs(prereq)) {
                return false;
            }
        }

        visiting.remove(course);
        prereqs.clear();
        preMap.put(course,prereqs);
        return true;
    }
}
