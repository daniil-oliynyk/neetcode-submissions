class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> hm = new HashMap<>();
        for (int i: nums) {
            hm.put(i, hm.getOrDefault(i,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for(Map.Entry<Integer,Integer> entry: hm.entrySet()) {
            pq.offer(entry);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[k];
        for(int i = 0; i<k; i++) {
            res[i] = pq.poll().getKey();
        }
        return res;

    }
}