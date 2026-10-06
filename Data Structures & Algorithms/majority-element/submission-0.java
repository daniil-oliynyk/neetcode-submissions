class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> freqs = new HashMap<>();
        int n = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            freqs.put(nums[i], freqs.getOrDefault(nums[i],0)+1);
        }

        for (Map.Entry<Integer,Integer> entry: freqs.entrySet()) {
            if (entry.getValue() > n) {
                return entry.getKey();
            }
        }

        return 0;
    }
}