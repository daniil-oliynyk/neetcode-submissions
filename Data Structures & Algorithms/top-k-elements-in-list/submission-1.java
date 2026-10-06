class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer> counts = new HashMap<>();
        for (int i : nums) {
            if (counts.containsKey(i)) {
                counts.replace(i, counts.get(i)+1);
            } else {
                counts.put(i,1);
            }
        }

        List<Integer>[] freqs = new List[nums.length+1];
        for (int i = 0; i < freqs.length; i++) {
            freqs[i] = new ArrayList<>();
        }
        
        for (Map.Entry<Integer,Integer> entry : counts.entrySet()) {
            freqs[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int idx = 0;
        for (int i = freqs.length -1; i > 0 && idx < k; i--) {
            for (int n : freqs[i]) {
                res[idx++] = n;
                if (idx == k) {
                    return res;
                }
            }
        }

        return res;

    }
}
