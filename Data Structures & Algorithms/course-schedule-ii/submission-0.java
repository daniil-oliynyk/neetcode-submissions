class Solution {

    HashMap<Integer,ArrayList<Integer>> preMap = new HashMap<>();
    HashSet<Integer> visit = new HashSet<>();
    HashSet<Integer> cycle = new HashSet<>();
    ArrayList<Integer> output = new ArrayList<>();


    public int[] findOrder(int numCourses, int[][] prerequisites) {

        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            ArrayList<Integer> prereqs = preMap.get(prereq[0]);
            prereqs.add(prereq[1]);
            preMap.put(prereq[0],prereqs);
        }

        for (int i = 0; i<numCourses;i++) {
            if (!dfs(i)) {
                return new int[0];
            }
        }
        int[] res = new int[numCourses];
        for (int i = 0; i<numCourses;i++) {
            res[i] = output.get(i);
        }
        return res;
    }

    public boolean dfs(int course) {
        if (cycle.contains(course)) {
            return false;
        }
        if (visit.contains(course)) {
            return true;
        }
        cycle.add(course);
        ArrayList<Integer> prereqs = preMap.get(course);
        for (int prereq: prereqs) {
            if (!dfs(prereq)) {
                return false;
            }
        }
        cycle.remove(course);
        visit.add(course);
        output.add(course);
        return true;

    }
}
