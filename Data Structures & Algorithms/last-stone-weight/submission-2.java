class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            if (first==second) {
                continue;
            }
            maxHeap.add(first-second);
        }
        if(maxHeap.size()==0) {
            return 0;
        }
        return maxHeap.poll();
    }
}
