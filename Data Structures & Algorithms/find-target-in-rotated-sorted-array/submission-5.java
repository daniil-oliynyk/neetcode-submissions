class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int pivot = -1;
        while (l<r) {
            int m = (l+r)/2;
            if (nums[m] < nums[r]) {
                r = m;
            } else {
                l = m +1;
            }
        }
        pivot = l;
      
        int ret = binarySearch(nums,target, 0,pivot-1);
        if (ret != -1) {
            return ret;
        }
        
        return binarySearch(nums,target, pivot,nums.length-1);
        
        
    }
    public int binarySearch(int[]nums, int target, int l, int r) {
        
        
        while (l<=r) {
            int m = (l+r)/2;
            if (target == nums[m]) {
                return m;
            } else if (target<nums[m]){
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return -1;
    }
}
