class Solution {
    public int majorityElement(int[] nums) {

        int count = 0;
        int res = 0;
        for (int i: nums) {
            if (count == 0) {
                res = i;
            }
            if (i == res) {
                count += 1;
            } else {
                count -= 1;
            }
        }
        return res;
        // HashMap<Integer,Integer> freqs = new HashMap<>();
        // int n = nums.length / 2;
        // for (int i = 0; i < nums.length; i++) {
        //     freqs.put(nums[i], freqs.getOrDefault(nums[i],0)+1);
        // }

        // for (Map.Entry<Integer,Integer> entry: freqs.entrySet()) {
        //     if (entry.getValue() > n) {
        //         return entry.getKey();
        //     }
        // }

        // return 0;
    }
}