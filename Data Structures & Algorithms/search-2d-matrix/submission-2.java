class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int leftIdx = 0;
        int rightIdx = matrix.length - 1;
        
        while (leftIdx <= rightIdx) {

            int[] leftList = matrix[leftIdx];
            int[] rightList = matrix[rightIdx];
            int midIdx = (leftIdx+rightIdx)/2;
            int[] midList = matrix[midIdx];

            if ((leftList[0] <= target) && (leftList[leftList.length-1] >= target)) {
                return binarySearch(leftList, target);
            }
            if ((midList[0] <= target) && (midList[midList.length-1] >= target)) {
                return binarySearch(midList, target);
            }
            if ((rightList[0] <= target) && (rightList[rightList.length-1] >= target)) {
                return binarySearch(rightList, target);
            }

            if (target < midList[0]){
                rightIdx = midIdx-1;
            } else if (target > midList[midList.length-1]){
                leftIdx = midIdx+1;
            }

        }

        return false;

    }

    public boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;

        while(low<=high){
            int mid = (low+high)/2;
            if (target == nums[mid]) {
                return true;
            }
            if (target < nums[mid]) {
                high = mid - 1;
            }
            if (target > nums[mid]){
                low = mid + 1;
            }
        }

        return false;
    }
}
