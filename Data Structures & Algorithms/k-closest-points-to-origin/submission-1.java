class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        for (int[] point : points) {
            int dist = point[0]*point[0] + point[1]*point[1];
            int[] triple = new int[]{dist,point[0],point[1]};
            minHeap.add(triple);
        }

        int[][] ret = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] triple = minHeap.poll();
            ret[i] = new int[]{triple[1],triple[2]};
        }
        return ret;



    }
}
