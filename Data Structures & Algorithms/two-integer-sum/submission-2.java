class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int i =0;i<nums.length;i++) {
            
            hm.put(nums[i], i);
        
        }
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (hm.containsKey(diff) && hm.get(diff) != i) {
                return new int[]{i, hm.get(diff)};
            }
        }
        return new int[0];
    }
}
