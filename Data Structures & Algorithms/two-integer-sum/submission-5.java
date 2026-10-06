class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> idxs = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            idxs.put(nums[i],i);
        }

        int[] ret = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (idxs.containsKey(diff) && (idxs.get(diff) != i)) {
                ret[0] = i;
                ret[1] = idxs.get(diff);
                Arrays.sort(ret);
                return ret;
            }
        }
        return ret;
    }
}
