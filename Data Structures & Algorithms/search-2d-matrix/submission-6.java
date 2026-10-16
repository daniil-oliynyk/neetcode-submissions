class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix.length == 1) {
            return searchRow(matrix[0],target);
        }

        int l = 0;
        int r = matrix.length - 1;

        while (l <= r) {
            int m = (r + l) / 2;        
            if (matrix[m][0]<=target && target<=matrix[m][matrix[m].length-1]) {
                if (matrix[m][0]==target || target==matrix[m][matrix[m].length-1]) {
                    return true;
                }
                return searchRow(matrix[m], target);
            }
            if (target < matrix[m][0]) {
                r = m - 1;
            } else if (target > matrix[m][matrix[m].length-1]) {
                l = m + 1;
            }
        }
        return false;
    
    }


    public boolean searchRow(int[] row, int target) {
        int l = 0;
        int r = row.length-1;

        while (l <= r){
            int m = l + ((r-l)/2);
            if (row[m]==target) {
                return true;
            } else if (row[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }    
        }
        return false;
    }
}
