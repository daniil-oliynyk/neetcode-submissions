class Solution {
    public void sortColors(int[] nums) {
        int[] buckets = new int[3];
        for(int i: nums) {
            buckets[i]++;
        }

        int index = 0;
        for (int i=0;i<3;i++) {
            while(buckets[i]-- > 0) {
                nums[index++] = i;
            }
        }


    }
}